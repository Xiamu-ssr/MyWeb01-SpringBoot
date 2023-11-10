package com.ruoyi.myweb.utils;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.myweb.domain.MyCounter;
import com.ruoyi.myweb.mapper.MyCounterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CountUtils {

    @Autowired
    private MyCounterMapper myCounterMapper;

    private String subFunc(int num){
        String res = "";
        //获取当前编码
        LambdaQueryWrapper<MyCounter> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(MyCounter::getId,num);
        List<MyCounter> cl = myCounterMapper.selectList(wrapper);
        res += cl.get(0).getPrefix();
        res += String.format("%0"+cl.get(0).getDigit()+"d", cl.get(0).getCurnum());
        //将编码+1
        wrapper.clear();
        wrapper.eq(MyCounter::getId,num);
        MyCounter upc = cl.get(0);
        upc.setCurnum(upc.getCurnum()+1);
        myCounterMapper.update(upc, wrapper);
        return res;
    }
    public String getImageTextNum(){
        return subFunc(1);
    }
    public String getImageNum(){
        return subFunc(2);
    }
}
