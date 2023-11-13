package com.ruoyi.myweb.dto;

import com.ruoyi.myweb.domain.MyImagetext;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class HomePageDataDto {
    private int programs;
    private int partners;
    private Map<String, Integer> geo;
    private Map<String, Integer> fourCards;
    private List<MyImagetext> curTimeLine;
}
