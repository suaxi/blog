package com.sw.blog.controller;

import com.sw.blog.exception.*;
import com.sw.blog.pojo.ResponseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @description controller基类
 * @author suaxi
 * @date 2021/10/29 14:47
 */
public abstract class BaseController {

    protected static final Integer SUCCESS = 200;

    protected static final Integer FAIL = 500;

    protected static final Integer EXCEPTION = 510;

    /**
     * 统一异常处理
     * @param e
     * @return
     */
    @ExceptionHandler({ServiceException.class})
    public ResponseResult<Void> handleException(Throwable e) {
        ResponseResult<Void> responseResult = new ResponseResult<>();
        responseResult.setMessage(e.getMessage());
        if (e instanceof DataNotFoundException) {
            responseResult.setState(404);
        } else if (e instanceof UpdateException) {
            responseResult.setState(500);
        } else if (e instanceof InsertException) {
            responseResult.setState(500);
        } else if (e instanceof DeleteException) {
            responseResult.setState(500);
        } else if (e instanceof IllegalArgumentException) {
            responseResult.setState(500);
        }
        return responseResult;
    }

}
