
//    2-8 SpringBoot 之统一异常封装处理
//2-10 自定义异常与拦截器整合返回JSON对象


package com.imooc.exception;

import com.imooc.utils.JSONResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.stream.FactoryConfigurationError;

/**
 *  统一异常拦截处理
 *  可以针对异常自定义去处理去捕获，返回指定的类型（json类型）到前端
 */
@ControllerAdvice
public class GraceExceptionHandler {

    @ExceptionHandler(FactoryConfigurationError.class)
    @ResponseBody
    public JSONResult returnMaxFileSizeLimit(FactoryConfigurationError e) {
        return JSONResult.errorMsg("文件大小不能超过500KB");
    }

//    2-10
    @ExceptionHandler(MyCustomException.class)
    @ResponseBody
    public JSONResult returnMyCustomException(MyCustomException e) {
        return JSONResult.errorMsg(e.getMessage());
    }
}
