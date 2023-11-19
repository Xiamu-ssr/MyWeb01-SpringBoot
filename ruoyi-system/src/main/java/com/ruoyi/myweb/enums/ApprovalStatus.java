package com.ruoyi.myweb.enums;

public enum ApprovalStatus {
    CANCEL(0, "未审批"),
    APPROVE(1, "已审批");

    private final int code;
    private final String name;

    ApprovalStatus(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }
}
