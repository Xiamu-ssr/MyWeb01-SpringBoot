package com.ruoyi.myweb.utils;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.myweb.domain.MyCounter;
import com.ruoyi.myweb.enums.MyCounterEnum;
import com.ruoyi.myweb.mapper.MyCounterMapper;
import com.ruoyi.myweb.service.IMyCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CountUtils {

    private static IMyCounterService myCounterService;

    @Autowired
    public CountUtils(IMyCounterService myCounterService){
        CountUtils.myCounterService = myCounterService;
    }
    public static String getImageTextNum(){
        return myCounterService.getNextNo(MyCounterEnum.IMAGE_TEXT);
    }
    public static String getImageNum(){
        return myCounterService.getNextNo(MyCounterEnum.IMAGES);
    }
    public static String getMessageNum(){
        return myCounterService.getNextNo(MyCounterEnum.MESSAGES);
    }
}
