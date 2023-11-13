package com.ruoyi.myweb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.myweb.domain.MyImagetext;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MyImagetextMapper extends BaseMapper<MyImagetext> {

    List<Map<String, Object>> getGeoData();
}
