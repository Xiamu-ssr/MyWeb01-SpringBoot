package com.ruoyi.myweb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.myweb.domain.MyMessage;
import com.ruoyi.myweb.dto.MessageBoardDto;
import com.ruoyi.myweb.enums.ApprovalStatus;
import com.ruoyi.myweb.mapper.MyMessageMapper;
import com.ruoyi.myweb.service.IMyMessageBoardService;
import com.ruoyi.myweb.utils.CountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

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

    @Override
    public HashMap<String, Integer> getTopData() {
        HashMap<String, Integer> res = new HashMap<>();
        LambdaQueryWrapper<MyMessage> lambdaWrapper = new LambdaQueryWrapper<>();
        int count = 0;
        //获取留言数量
        count = myMessageMapper.selectCount(lambdaWrapper);
        res.put("messageNum", count);
        //获取留言人数
        count = myMessageMapper.selectCount(new QueryWrapper<MyMessage>().select("distinct name"));
        res.put("peopleNum", count);
        //获取留言字数
        count = 0;
        lambdaWrapper.clear();
        lambdaWrapper.select(MyMessage::getText);
        List<MyMessage> list = myMessageMapper.selectList(lambdaWrapper);
        for (int i = 0; i < list.size(); i++) {
            count += list.get(i).getText().length();
        }
        res.put("textNum", count);
        return res;
    }

    @Override
    public List<MyMessage> getList(MessageBoardDto dto) {
        LambdaQueryWrapper<MyMessage> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(dto.getStatus() != null, MyMessage::getStatus, dto.getStatus());
        if (dto.getDate()!=null && dto.getDate().size()==2){
            wrapper.between(MyMessage::getCreateTime, dto.getDate().get(0), dto.getDate().get(1));
        }
        List<MyMessage> res = myMessageMapper.selectList(wrapper);
        System.out.println(res);
        return res;
    }

    @Override
    public AjaxResult changeStatus(String id, int status) {
        LambdaUpdateWrapper<MyMessage> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(MyMessage::getId, id);
        wrapper.set(MyMessage::getStatus, status);
        int res = myMessageMapper.update(null, wrapper);
        if (res == 1){
            return AjaxResult.success();
        }else {
            return AjaxResult.error();
        }
    }
}
