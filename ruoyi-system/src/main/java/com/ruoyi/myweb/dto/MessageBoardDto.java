package com.ruoyi.myweb.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class MessageBoardDto {
    private String status;
    private List<Date> date;
}
