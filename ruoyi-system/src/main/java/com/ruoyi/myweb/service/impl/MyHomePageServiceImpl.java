package com.ruoyi.myweb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.myweb.domain.MyImagetext;
import com.ruoyi.myweb.dto.HomePageDataDto;
import com.ruoyi.myweb.mapper.MyImagetextMapper;
import com.ruoyi.myweb.service.IMyHomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.naming.IdentityNamingStrategy;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MyHomePageServiceImpl implements IMyHomePageService {

    @Autowired
    MyImagetextMapper myImagetextMapper;
    @Override
    public HomePageDataDto getAllData() {
        HomePageDataDto res = new HomePageDataDto();
        res.setPrograms(5);
        res.setPartners(2);

        //获取各省动态数量
        HashMap<String, Integer> geo = new HashMap<>();
        List<Map<String, Object>> geoData = myImagetextMapper.getGeoData();
        System.out.println(geoData);
        geoData.forEach(g->{
            geo.put(g.get("place").toString(), Integer.parseInt(g.get("num").toString()));
        });
        res.setGeo(geo);

        return res;
    }
}
