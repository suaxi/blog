package com.sw.blog.exception;

/**
 * @Description
 * @Author suaxi
 * @Date 2021/10/29 14:49
 */
public class UpdateException extends RuntimeException{

    public UpdateException() {
        super();
    }

    public UpdateException(String message) {
        super(message);
    }

    public UpdateException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public UpdateException(Throwable throwable) {
        super(throwable);
    }

    public UpdateException(String message, Throwable throwable, boolean enableSuppression, boolean writableStackTrace) {
        super(message, throwable, enableSuppression, writableStackTrace);
    }
}
