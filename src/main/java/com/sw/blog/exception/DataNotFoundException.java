package com.sw.blog.exception;

/**
 * @Description 业务异常
 * @Author suaxi
 * @Date 2021/10/29 14:49
 */
public class DataNotFoundException extends RuntimeException{

    public DataNotFoundException() {
        super();
    }

    public DataNotFoundException(String message) {
        super(message);
    }

    public DataNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public DataNotFoundException(Throwable throwable) {
        super(throwable);
    }

    public DataNotFoundException(String message, Throwable throwable, boolean enableSuppression, boolean writableStackTrace) {
        super(message, throwable, enableSuppression, writableStackTrace);
    }
}
