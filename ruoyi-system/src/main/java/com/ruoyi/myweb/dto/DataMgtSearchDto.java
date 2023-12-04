package com.ruoyi.myweb.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
public class DataMgtSearchDto {
    private List<String> place;
    private String title;
    private String text;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private List<Date> date;
}
