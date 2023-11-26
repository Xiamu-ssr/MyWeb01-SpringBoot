package com.ruoyi.myweb.domain;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("my_portfolio")
public class MyPortfolio {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String title;
    private String fileUrl;
    private String tags;
    private String url;
}
