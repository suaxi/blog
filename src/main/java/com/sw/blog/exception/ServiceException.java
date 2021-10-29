package com.sw.blog.exception;

/**
 * @Description
 * @Author suaxi
 * @Date 2021/10/29 14:49
 */
public class ServiceException extends RuntimeException{

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public ServiceException(Throwable throwable) {
        super(throwable);
    }

    public ServiceException(String message, Throwable throwable, boolean enableSuppression, boolean writableStackTrace) {
        super(message, throwable, enableSuppression, writableStackTrace);
    }
}
