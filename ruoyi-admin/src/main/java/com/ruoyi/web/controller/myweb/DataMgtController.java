package com.ruoyi.web.controller.myweb;


import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.myweb.service.IMyDataMgtService;
import com.ruoyi.myweb.service.impl.MyDataMgtServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
}
