package com.sw.blog.handler;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @description
 * @author suaxi
 * @date 2021/10/28 11:24
 */
@Slf4j
@Component
public class MetaObjectHandler implements com.baomidou.mybatisplus.core.handlers.MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("MyBatis-Plus Auto Interceptor");
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("MyBatis-Plus Auto Interceptor");
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }
}
