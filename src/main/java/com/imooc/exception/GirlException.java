package com.imooc.exception;

import com.imooc.entity.Girl;
import com.imooc.enums.ResultEnum;

public class GirlException extends RuntimeException {
    private Integer stateCode;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getStateInfo());
        this.stateCode = resultEnum.getStateCode();
    }

    // Getter & Setter

    public Integer getStateCode() {
        return stateCode;
    }

    public void setStateCode(Integer stateCode) {
        this.stateCode = stateCode;
    }
}
