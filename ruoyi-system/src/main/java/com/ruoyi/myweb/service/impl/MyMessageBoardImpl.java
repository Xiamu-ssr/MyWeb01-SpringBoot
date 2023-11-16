package com.ruoyi.myweb.service.impl;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.myweb.domain.MyMessage;
import com.ruoyi.myweb.mapper.MyMessageMapper;
import com.ruoyi.myweb.service.IMyMessageBoardService;
import com.ruoyi.myweb.utils.CountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MyMessageBoardImpl implements IMyMessageBoardService {

    @Autowired
    MyMessageMapper myMessageMapper;
    @Autowired
    private CountUtils countUtils;
    @Override
    public AjaxResult create(MyMessage myMessage) {
        myMessage.setId(countUtils.getMessageNum());
        myMessage.setCreateTime(new Date());
        myMessageMapper.insert(myMessage);
        return AjaxResult.success();
    }
}
