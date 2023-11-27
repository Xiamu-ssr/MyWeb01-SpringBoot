package com.ruoyi.myweb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.myweb.domain.MyPortfolio;
import com.ruoyi.myweb.dto.PortfolioDto;
import com.ruoyi.myweb.mapper.MyPortfolioMapper;
import com.ruoyi.myweb.service.IMyPortfolioService;
import com.ruoyi.myweb.vo.PortfolioListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MyPortfolioServiceImpl implements IMyPortfolioService {

    @Autowired
    MyPortfolioMapper myPortfolioMapper;

    @Override
    public AjaxResult create(PortfolioDto dto) {
        System.out.println(dto);
        MyPortfolio portfolio = new MyPortfolio();
        portfolio.setTitle(dto.getTitle());
        portfolio.setFileUrl(dto.getFileUrl());
        portfolio.setTags(dto.getTags().toString());
        portfolio.setUrl(dto.getUrl());
        portfolio.setOrderNum(dto.getOrderNum());
        myPortfolioMapper.insert(portfolio);
        return AjaxResult.success();
    }

    @Override
    public List<PortfolioListVo> getList() {
        List<PortfolioListVo> res = new ArrayList<>();
        List<MyPortfolio> lists = myPortfolioMapper.selectList(new LambdaQueryWrapper<MyPortfolio>().orderByAsc(MyPortfolio::getOrderNum));
        lists.forEach(myPortfolio -> {
            PortfolioListVo tmp = new PortfolioListVo();
            tmp.setId(String.valueOf(myPortfolio.getId()));
            tmp.setTitle(myPortfolio.getTitle());
            tmp.setFileUrl(myPortfolio.getFileUrl());
            tmp.setUrl(myPortfolio.getUrl());
            tmp.setOrderNum(myPortfolio.getOrderNum());
            String tags = myPortfolio.getTags();
            String substring = tags.substring(1, tags.length() - 1);
            String[] strings = substring.split(", ");
            tmp.setTags(new ArrayList<>(Arrays.asList(strings)));
            res.add(tmp);
        });
        return res;
    }

    @Override
    public AjaxResult deleteById(String id) {
        System.out.println(id);
        LambdaQueryWrapper<MyPortfolio> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(MyPortfolio::getId, Long.valueOf(id));
        myPortfolioMapper.delete(wrapper);
        return AjaxResult.success();
    }

    @Override
    public AjaxResult updateOrder(PortfolioListVo dto) {
        LambdaUpdateWrapper<MyPortfolio> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(MyPortfolio::getId, dto.getId())
                .set(MyPortfolio::getOrderNum, dto.getOrderNum());
        int res = myPortfolioMapper.update(null, updateWrapper);
        if (res == 1){
            return AjaxResult.success();
        }else {
            return AjaxResult.error();
        }
    }
}
