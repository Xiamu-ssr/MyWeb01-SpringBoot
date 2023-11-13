package com.ruoyi.web.controller.myweb;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.myweb.service.IMyHomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/HomePage")
public class HomePageController extends BaseController {

    @Autowired
    IMyHomePageService myHomePageService;

    @PostMapping("/getAllData")
    public AjaxResult getAllData(){
        return success(myHomePageService.getAllData());
    }
}
