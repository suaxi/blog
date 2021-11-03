package com.sw.blog.exception;

/**
 * @description
 * @author suaxi
 * @date 2021/10/29 14:49
 */
public class DeleteException extends RuntimeException{

    public DeleteException() {
        super();
    }

    public DeleteException(String message) {
        super(message);
    }

    public DeleteException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public DeleteException(Throwable throwable) {
        super(throwable);
    }

    public DeleteException(String message, Throwable throwable, boolean enableSuppression, boolean writableStackTrace) {
        super(message, throwable, enableSuppression, writableStackTrace);
    }
}
