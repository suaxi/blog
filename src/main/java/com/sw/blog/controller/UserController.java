package com.sw.blog.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sw.blog.constant.StringConstant;
import com.sw.blog.pojo.ResponseResult;
import com.sw.blog.pojo.User;
import com.sw.blog.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @Description
 * @Author suaxi
 * @Date 2021/10/29 14:36
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户接口")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @ApiOperation("根据用户名查询用户信息")
    @ApiImplicitParam(name = "username", value = "用户名", required = true, paramType = "path", dataType = "String")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/findUserByName/{username}")
    public ResponseResult<User> findUserByName(@NotNull @PathVariable("username") String username) {
        return new ResponseResult<>(SUCCESS, userService.findUserByName(username));
    }

    @ApiOperation("新增用户")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping
    public ResponseResult<User> createUser(@Valid User user) {
        if (userService.createUser(user)) {
            return new ResponseResult<>(SUCCESS, "新增用户成功！");
        }
        return new ResponseResult<>(FAIL, "新增用户失败！");
    }

    @ApiOperation("修改用户")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping
    public ResponseResult<User> updateUser(@Valid User user) {
        if (userService.updateUser(user)) {
            return new ResponseResult<>(SUCCESS, "修改用户信息成功！");
        }
        return new ResponseResult<>(FAIL, "修改用户信息失败！");
    }

    @ApiOperation("删除用户")
    @ApiImplicitParam(name = "userIds", value = "用户名ID", required = true, paramType = "path", dataType = "String")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/{userIds}")
    public ResponseResult<Integer> deleteUserByIds(@NotNull @PathVariable("userIds") String userIds) {
        if (userService.deleteUserByIds(userIds.split(StringConstant.COMMA))) {
            return new ResponseResult<>(SUCCESS, "删除成功！");
        }
        return new ResponseResult<>(FAIL, "删除失败！");
    }

    @ApiOperation("查询用户列表（分页）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, paramType = "path", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "页面大小", required = true, paramType = "path", dataType = "Integer")
    })
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/findUserPage/{pageNum}/{pageSize}")
    public ResponseResult<Page> findUserPage(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) {
        return new ResponseResult<>(SUCCESS, userService.findUserPage(pageNum, pageSize));
    }

    @ApiOperation("用户名校验")
    @ApiImplicitParam(name = "username", value = "用户名", required = true, paramType = "path", dataType = "String")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/checkUsername/{username}")
    public ResponseResult<Boolean> checkUsername(@NotNull @PathVariable("username") String username) {
        return new ResponseResult<>(SUCCESS, userService.findUserByName(username) == null);
    }

    @ApiOperation("修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, paramType = "path", dataType = "Integer"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "path", dataType = "String")
    })
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/updatePassword/{userId}/{password}")
    public ResponseResult<Boolean> updatePassword(@NotNull @PathVariable("userId") Integer userId, @NotNull @PathVariable("password") String password) {
        if (userService.updatePassword(userId, password)) {
            return new ResponseResult<>(SUCCESS, "用户密码修改成功！");
        }
        return new ResponseResult<>(FAIL, "用户密码修改失败！");
    }
}
