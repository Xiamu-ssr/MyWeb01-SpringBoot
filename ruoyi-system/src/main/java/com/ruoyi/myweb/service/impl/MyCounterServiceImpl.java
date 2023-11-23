package com.ruoyi.myweb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.myweb.domain.MyCounter;
import com.ruoyi.myweb.enums.MyCounterEnum;
import com.ruoyi.myweb.mapper.MyCounterMapper;
import com.ruoyi.myweb.service.IMyCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyCounterServiceImpl implements IMyCounterService {

    @Autowired
    private MyCounterMapper myCounterMapper;

    @Override
    public String getNextNo(MyCounterEnum param) {
        String res = "";
        //获取当前编码
        LambdaQueryWrapper<MyCounter> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(MyCounter::getName,param.getName());
        List<MyCounter> cl = myCounterMapper.selectList(wrapper);
        res += cl.get(0).getPrefix();
        res += String.format("%0"+cl.get(0).getDigit()+"d", cl.get(0).getCurnum());
        //将编码+1
        wrapper.clear();
        wrapper.eq(MyCounter::getName,param.getName());
        MyCounter upc = cl.get(0);
        upc.setCurnum(upc.getCurnum()+1);
        myCounterMapper.update(upc, wrapper);
        return res;
    }
}
