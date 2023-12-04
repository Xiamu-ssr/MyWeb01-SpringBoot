package com.ruoyi.myweb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.myweb.domain.MyImagetext;
import com.ruoyi.myweb.domain.MyMessage;
import com.ruoyi.myweb.domain.MyPortfolio;
import com.ruoyi.myweb.dto.HomePageDataDto;
import com.ruoyi.myweb.mapper.MyImagesMapper;
import com.ruoyi.myweb.mapper.MyImagetextMapper;
import com.ruoyi.myweb.mapper.MyMessageMapper;
import com.ruoyi.myweb.mapper.MyPortfolioMapper;
import com.ruoyi.myweb.service.IMyHomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.naming.IdentityNamingStrategy;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class MyHomePageServiceImpl implements IMyHomePageService {

    @Autowired
    MyImagetextMapper myImagetextMapper;
    @Autowired
    MyImagesMapper myImagesMapper;
    @Autowired
    MyMessageMapper myMessageMapper;
    @Autowired
    MyPortfolioMapper myPortfolioMapper;

    @Override
    public HomePageDataDto getAllData() {
        HomePageDataDto res = new HomePageDataDto();
        //获取项目数量
        res.setPrograms(myPortfolioMapper.selectCount(new QueryWrapper<MyPortfolio>()));
        //计算友链数量
        res.setPartners(2);
        //获取各省动态数量
        HashMap<String, Integer> geo = new HashMap<>();
        List<Map<String, Object>> geoData = myImagetextMapper.getGeoData();
//        System.out.println(geoData);
        geoData.forEach(g->{
            geo.put(g.get("place").toString(), Integer.parseInt(g.get("num").toString()));
        });
        res.setGeo(geo);
        //获取四张cards数据
        Map<String, Integer> fourCards = new HashMap<>();
        //1.总图片数量
        fourCards.put("0", myImagesMapper.selectCount(new LambdaQueryWrapper<>()));
        //2.动态数量
        fourCards.put("1", myImagetextMapper.selectCount(new LambdaQueryWrapper<>()));
        //3.留言数量
        fourCards.put("2", myMessageMapper.selectCount(new QueryWrapper<MyMessage>().select("distinct name")));
        //4.至今时间
        try {
            Date start = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2023-11-11 00:00:00");
            Date end = new Date();
            long diffInMillies = Math.abs(end.getTime() - start.getTime());
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            fourCards.put("3", Long.valueOf(diff).intValue());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        res.setFourCards(fourCards);
        //获取最新5条动态概览
        LambdaQueryWrapper<MyImagetext> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByDesc(MyImagetext::getCreateTime)
                .last("limit 5");
        List<MyImagetext> list = myImagetextMapper.selectList(wrapper);
        res.setCurTimeLine(list);

        return res;
    }
}
