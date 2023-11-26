package com.ruoyi.web.controller.myweb;


import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.myweb.dto.PortfolioDto;
import com.ruoyi.myweb.service.IMyPortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Portfolio")
public class PortfolioController extends BaseController {

    @Autowired
    IMyPortfolioService myPortfolioService;
    @PostMapping("/create")
    public AjaxResult createNew(@RequestBody PortfolioDto dto){
        return myPortfolioService.create(dto);
    }

    @GetMapping("getList")
    public AjaxResult getList(){
        return success(myPortfolioService.getList());
    }

    @PostMapping("delete")
    public AjaxResult deleteById(@RequestBody String id){
        return myPortfolioService.deleteById(id);
    }
}
