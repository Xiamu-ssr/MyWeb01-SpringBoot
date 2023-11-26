package com.ruoyi.myweb.service;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.myweb.domain.MyPortfolio;
import com.ruoyi.myweb.dto.PortfolioDto;
import com.ruoyi.myweb.vo.PortfolioListVo;

import java.util.List;

public interface IMyPortfolioService {

    AjaxResult create(PortfolioDto dto);

    List<PortfolioListVo> getList();

    AjaxResult deleteById(String id);
}
