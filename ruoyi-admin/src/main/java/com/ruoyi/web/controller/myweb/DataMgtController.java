package com.ruoyi.web.controller.myweb;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.myweb.dto.DataMgtSearchDto;
import com.ruoyi.myweb.service.IMyDataMgtService;
import com.ruoyi.myweb.service.impl.MyDataMgtServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/DataMgt")
public class DataMgtController extends BaseController {

    @Autowired
    private IMyDataMgtService myDataMgtService;

    @PostMapping("/getId")
    public AjaxResult create() {
        return success(myDataMgtService.getId());
    }

    @PostMapping("/uploadPic")
    public AjaxResult uploadPic(MultipartFile file, String id) throws IOException {
        return success(myDataMgtService.insertOnePic(file,id));
    }

    @PostMapping("/deletePic")
    public AjaxResult deletePic(@RequestBody String name){
        System.out.println(name);
        return success(myDataMgtService.deleteOnePic(name));
    }

    @Log(title = "动态管理-创建新动态", businessType = BusinessType.INSERT)
    @PostMapping("/createImageText")
    public AjaxResult createImageText(@RequestBody Map<String,String> params){
        if (myDataMgtService.createImageText(params)!=0){
            return success();
        }else {
            return error();
        }
    }

    //取消创建或删除动态
    @PostMapping("/cancelImageText")
    public AjaxResult cancelImageText(@RequestBody String id){
        myDataMgtService.cancelImageText(id);
        return success();
    }

    @PostMapping("/getList")
    public AjaxResult getList(@RequestBody DataMgtSearchDto dto){
        return success(myDataMgtService.getList(dto));
    }
}
