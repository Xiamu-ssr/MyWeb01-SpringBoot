package com.ruoyi.myweb.service;

import com.ruoyi.myweb.dto.DataMgtOneInfoDto;

import java.util.List;

public interface IMyTimeLineService {

    public List<DataMgtOneInfoDto> getListByPlace(String place);
}
