
//    2-10 自定义异常与拦截器整合返回JSON对象

package com.imooc.exception;

/**
 * 自定义异常
 * 目的：统一处理异常信息，便于解耦
 */
public class MyCustomException extends RuntimeException {
    public MyCustomException(String errorMsg) {
        super(errorMsg);
    }
}
