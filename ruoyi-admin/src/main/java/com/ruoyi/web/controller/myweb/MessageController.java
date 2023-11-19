package com.ruoyi.web.controller.myweb;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.myweb.domain.MyMessage;
import com.ruoyi.myweb.dto.MessageBoardDto;
import com.ruoyi.myweb.enums.ApprovalStatus;
import com.ruoyi.myweb.service.IMyMessageBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

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

    @PostMapping("/getTopData")
    public AjaxResult getTopData(){
        return success(myMessageBoardService.getTopData());
    }

    @PostMapping("/getList")
    public AjaxResult getList(@RequestBody MessageBoardDto dto){
        return success(myMessageBoardService.getList(dto));
    }

    @PostMapping("/confirmCheck")
    public AjaxResult confirmCheck(@RequestBody String id){
        return myMessageBoardService.changeStatus(id, ApprovalStatus.APPROVE.getCode());
    }

    @PostMapping("/cancelCheck")
    public AjaxResult cancelCheck(@RequestBody String id){
        return myMessageBoardService.changeStatus(id, ApprovalStatus.CANCEL.getCode());
    }
}
