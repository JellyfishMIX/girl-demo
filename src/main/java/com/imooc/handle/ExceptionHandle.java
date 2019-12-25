package com.imooc.handle;

import com.imooc.entity.Result;
import com.imooc.exception.GirlException;
import com.imooc.util.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof GirlException) {
            GirlException girlException = (GirlException) e;
            return ResultUtil.error(girlException.getStateCode(), girlException.getMessage());
        } else {
            return ResultUtil.error(-1, e.getMessage());
        }
    }
}
