package com.ruoyi.myweb.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
@TableName("my_imagestext")
public class MyImagetext {
    private String id;
    private String title;
    private String text;
    private String place;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}