package com.ruoyi.myweb.service;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.myweb.domain.MyMessage;
import com.ruoyi.myweb.dto.MessageBoardDto;
import com.ruoyi.myweb.enums.ApprovalStatus;

import java.util.HashMap;
import java.util.List;

public interface IMyMessageBoardService {
    AjaxResult create(MyMessage myMessage);

    HashMap<String, Integer> getTopData();

    List<MyMessage> getList(MessageBoardDto dto);

    AjaxResult changeStatus(String id, int status);
}
