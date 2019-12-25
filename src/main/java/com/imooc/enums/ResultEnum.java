package com.imooc.enums;

public enum ResultEnum {
    SUCCESS(1, "操作成功"),
    UNKNOW(-1001, "未知错误"),
    PRIMARY_SCHOOL(-2001, "年龄不足，还在上小学"),
    MIDDLE_SCHOOL(-2002, "年龄不足，还在上初中");

    private Integer stateCode;
    private String stateInfo;

    ResultEnum(Integer stateCode, String stateInfo) {
        this.stateCode = stateCode;
        this.stateInfo = stateInfo;
    }

    // Getter & Setter

    public Integer getStateCode() {
        return stateCode;
    }

    public void setStateCode(Integer stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }
}
