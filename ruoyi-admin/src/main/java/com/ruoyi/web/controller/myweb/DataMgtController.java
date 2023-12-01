package com.ruoyi.web.controller.myweb;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.myweb.dto.DataMgtSearchDto;
import com.ruoyi.myweb.service.IMyDataMgtService;
import com.ruoyi.myweb.service.impl.MyDataMgtServiceImpl;
import com.ruoyi.myweb.vo.DataMgtSearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 数据管理控制器
 *
 * @author mumu
 * @date 2023/11/11
 */
@RestController
@RequestMapping("/DataMgt")
public class DataMgtController extends BaseController {

    @Autowired
    private IMyDataMgtService myDataMgtService;

    /**
     * 创造
     *
     * @return {@link AjaxResult}
     */
    @PostMapping("/getId")
    public AjaxResult create() {
        return success(myDataMgtService.getId());
    }

    /**
     * 上传图片
     *
     * @param file 文件
     * @param id   id
     * @return {@link AjaxResult}
     * @throws IOException IOException
     */
    @PostMapping("/uploadPic")
    public AjaxResult uploadPic(MultipartFile file, String id) throws IOException {
        return success(myDataMgtService.insertOnePic(file,id));
    }

    /**
     * 删除图片
     *
     * @param name 名称
     * @return {@link AjaxResult}
     */
    @PostMapping("/deletePic")
    public AjaxResult deletePic(@RequestBody String name){
        System.out.println(name);
        return success(myDataMgtService.deleteOnePic(name));
    }

    /**
     * 创建图像文本
     *
     * @param params params
     * @return {@link AjaxResult}
     */
    @Log(title = "动态管理-创建新动态", businessType = BusinessType.INSERT)
    @PostMapping("/createImageText")
    public AjaxResult createImageText(@RequestBody Map<String,String> params){
        if (myDataMgtService.createImageText(params)!=0){
            return success();
        }else {
            return error();
        }
    }

    /**
     * 取消图像文本
     *
     * @param id id
     * @return {@link AjaxResult}
     */
    @PostMapping("/cancelImageText")
    public AjaxResult cancelImageText(@RequestBody String id){
        myDataMgtService.cancelImageText(id);
        return success();
    }

    /**
     * 获取列表
     *
     * @param dto 到
     * @return {@link AjaxResult}
     */
    @GetMapping("/getList")
    public AjaxResult getList(DataMgtSearchDto dto){
        startPage();
        List<DataMgtSearchVo> list = myDataMgtService.getList(dto);
        TableDataInfo dataTable = getDataTable(list);
        return success(dataTable);
    }

    @PostMapping("/getImageTextById")
    public AjaxResult getImageTextById(@RequestBody String id){
        return success(myDataMgtService.getImageTextById(id));
    }
}
