package com.ruoyi.web.controller.myweb;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.myweb.domain.MyMessage;
import com.ruoyi.myweb.service.IMyMessageBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/MessageBoard")
public class MessageController extends BaseController {

    @Autowired
    IMyMessageBoardService myMessageBoardService;

    @PostMapping("/create")
    public AjaxResult create(@RequestBody MyMessage myMessage){
        System.out.println(myMessage);
        return myMessageBoardService.create(myMessage);
    }
}
