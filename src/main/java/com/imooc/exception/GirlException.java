package com.imooc.exception;

import com.imooc.entity.Girl;

public class GirlException extends RuntimeException {
    private Integer stateCode;

    public GirlException(Integer stateCode, String stateInfo) {
        super(stateInfo);
        this.stateCode = stateCode;
    }

    // Getter & Setter

    public Integer getStateCode() {
        return stateCode;
    }

    public void setStateCode(Integer stateCode) {
        this.stateCode = stateCode;
    }
}
