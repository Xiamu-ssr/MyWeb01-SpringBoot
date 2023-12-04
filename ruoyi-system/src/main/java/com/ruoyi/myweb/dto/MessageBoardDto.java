package com.ruoyi.myweb.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Data
public class MessageBoardDto {
    private String status;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private List<Date> date;
}
