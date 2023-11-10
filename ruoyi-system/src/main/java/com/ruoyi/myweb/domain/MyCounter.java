package com.ruoyi.myweb.domain;

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
public class MyCounter
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 前缀 */
    @Excel(name = "前缀")
    private String prefix;

    /** 数字长度，数字位数 */
    @Excel(name = "数字长度，数字位数")
    private Long digit;

    /** 当前值 */
    @Excel(name = "当前值")
    private Long curnum;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setPrefix(String prefix)
    {
        this.prefix = prefix;
    }

    public String getPrefix()
    {
        return prefix;
    }
    public void setDigit(Long digit)
    {
        this.digit = digit;
    }

    public Long getDigit()
    {
        return digit;
    }
    public void setCurnum(Long curnum)
    {
        this.curnum = curnum;
    }

    public Long getCurnum()
    {
        return curnum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("prefix", getPrefix())
                .append("digit", getDigit())
                .append("curnum", getCurnum())
                .toString();
    }
}
