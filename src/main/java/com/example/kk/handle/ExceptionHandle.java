// 异常统一管理的地方(捕获到异常)
package com.example.kk.handle;

import com.example.kk.domain.Result;
import com.example.kk.exception.GirlException;
import com.example.kk.utils.ResultUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class); // 注意选sf4j库里的

    @ExceptionHandler(value = Exception.class) // 声明捕获的是Exception的这个异常类
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof GirlException) {
            GirlException girlException = (GirlException) e;
            return ResultUtil.error(girlException.getCode(), girlException.getMessage());
        } else {
            logger.info("[系统异常]", e);
            return ResultUtil.error(-1,"未知错误");
        }
    }

}
