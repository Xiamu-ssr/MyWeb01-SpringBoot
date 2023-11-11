package com.ruoyi.myweb.dto;

import com.ruoyi.myweb.domain.MyImages;
import com.ruoyi.myweb.domain.MyImagetext;
import lombok.Data;

import java.util.List;

@Data
public class DataMgtOneInfoDto extends MyImagetext {
    private List<MyImages> images;
}
