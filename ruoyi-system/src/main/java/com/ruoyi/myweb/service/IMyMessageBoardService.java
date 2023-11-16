package com.ruoyi.myweb.service;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.myweb.domain.MyMessage;

public interface IMyMessageBoardService {
    AjaxResult create(MyMessage myMessage);
}
