package com.ruoyi.myweb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.myweb.domain.MyImages;
import com.ruoyi.myweb.domain.MyImagetext;
import com.ruoyi.myweb.dto.DataMgtOneInfoDto;
import com.ruoyi.myweb.mapper.MyImagetextMapper;
import com.ruoyi.myweb.service.IMyDataMgtService;
import com.ruoyi.myweb.service.IMyTimeLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MyTimeLineServiceImpl implements IMyTimeLineService {

    @Autowired
    MyImagetextMapper myImagetextMapper;

    @Autowired
    IMyDataMgtService myDataMgtService;
    @Override
    public List<DataMgtOneInfoDto> getListByPlace(String place) {
        List<DataMgtOneInfoDto> res = new ArrayList<>();
        LambdaQueryWrapper<MyImagetext> wrapper1 = new LambdaQueryWrapper<>();
        //只选择id列，提高传输效率
        wrapper1.eq(!place.isEmpty(), MyImagetext::getPlace, place)
                .orderByDesc(MyImagetext::getCreateTime)
                .select(MyImagetext::getId);
        List<String> idList = myImagetextMapper.selectList(wrapper1).stream().map(MyImagetext::getId).collect(Collectors.toList());
        idList.forEach(id->{
            DataMgtOneInfoDto imageText = myDataMgtService.getImageTextById(id);
            res.add(imageText);
        });
        return res;
    }
}
