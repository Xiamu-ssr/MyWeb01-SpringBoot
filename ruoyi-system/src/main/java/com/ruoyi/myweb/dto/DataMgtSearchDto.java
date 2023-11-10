package com.ruoyi.myweb.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class DataMgtSearchDto {
    private List<String> place;
    private String title;
    private String text;
    private List<Date> date;
}
