package com.sw.blog.exception;

/**
 * @Description
 * @Author suaxi
 * @Date 2021/10/29 14:49
 */
public class InsertException extends RuntimeException{

    public InsertException() {
        super();
    }

    public InsertException(String message) {
        super(message);
    }

    public InsertException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public InsertException(Throwable throwable) {
        super(throwable);
    }

    public InsertException(String message, Throwable throwable, boolean enableSuppression, boolean writableStackTrace) {
        super(message, throwable, enableSuppression, writableStackTrace);
    }
}
