package com.ruoyi.myweb.dto;

import lombok.Data;

import java.util.List;

@Data
public class PortfolioDto {
    private String title;
    private String fileUrl;
    private String url;
    private List<String> tags;
}
