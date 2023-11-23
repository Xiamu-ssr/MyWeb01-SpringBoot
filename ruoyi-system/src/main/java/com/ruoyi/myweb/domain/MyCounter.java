package com.ruoyi.myweb.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 编号，号码，id等规则生成器=前缀+数字对象 my_counter
 *
 * @author ruoyi
 * @date 2023-11-08
 */
@Data
@TableName("my_counter")
public class MyCounter
{
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String prefix;
    private Long digit;
    private Long curnum;

}
