package com.sw.blog.controller;

import com.sw.blog.pojo.ResponseResult;
import com.sw.blog.pojo.User;
import com.sw.blog.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * @Description
 * @Author suaxi
 * @Date 2021/10/29 14:36
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @ApiOperation("根据用户名查询用户信息")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/findUserByName/{username}")
    public ResponseResult<User> findUserByName(@NotNull @PathVariable("username") String username) {
        return new ResponseResult<>(SUCCESS, userService.findUserByName(username));
    }
}
