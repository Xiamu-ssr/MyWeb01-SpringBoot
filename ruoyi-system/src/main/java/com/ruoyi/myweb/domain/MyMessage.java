package com.ruoyi.myweb.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
@TableName("my_message")
public class MyMessage {
    private String id;
    private String name;
    private String nameColor;
    private String nameEffect;
    private String text;
    private String status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}
