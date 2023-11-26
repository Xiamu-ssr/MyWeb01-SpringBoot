package com.ruoyi.myweb.vo;

import lombok.Data;

import java.util.List;

@Data
public class PortfolioListVo {
    private String id;
    private String title;
    private String fileUrl;
    private String url;
    private List<String> tags;
}
