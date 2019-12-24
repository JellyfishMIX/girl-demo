package com.imooc.util;

import com.imooc.entity.Result;

public class ResultUtil {
    public static Result success(Object object) {
        Result result = new Result<>();
        result.setStateCode(1);
        result.setStateInfo("success");
        result.setData(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(Integer stateCode, String stateInfo) {
        Result result = new Result<>();
        result.setStateCode(stateCode);
        result.setStateInfo(stateInfo);
        return result;
    }
}
