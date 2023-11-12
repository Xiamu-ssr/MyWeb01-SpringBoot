package com.ruoyi.web.controller.myweb;


import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.myweb.service.IMyTimeLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/TimeLine")
public class TimeLineController extends BaseController {

    @Autowired
    IMyTimeLineService myTimeLineService;

    @PostMapping("/getListByPlace")
    public AjaxResult getListByPlace(@RequestBody String place){

        return success(myTimeLineService.getListByPlace(place));
    }
}
