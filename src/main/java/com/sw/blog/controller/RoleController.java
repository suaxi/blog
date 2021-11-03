package com.sw.blog.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sw.blog.constant.StringConstant;
import com.sw.blog.pojo.ResponseResult;
import com.sw.blog.pojo.Role;
import com.sw.blog.service.RoleService;
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
 * @description
 * @author suaxi
 * @date 2021/10/30 23:44
 */
@RestController
@RequestMapping("/role")
@Api(tags = "角色接口")
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;

    @ApiOperation("根据角色名查询角色信息")
    @ApiImplicitParam(name = "roleName", value = "角色名", required = true, paramType = "path", dataType = "String")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/findRoleByName/{roleName}")
    public ResponseResult<Role> findRoleByName(@NotNull @PathVariable("roleName") String roleName) {
        return new ResponseResult<>(SUCCESS, roleService.findRoleByName(roleName));
    }

    @ApiOperation("新增角色")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping
    public ResponseResult<Role> createUser(@Valid Role role) {
        if (roleService.createRole(role)) {
            return new ResponseResult<>(SUCCESS, "新增角色成功！");
        }
        return new ResponseResult<>(FAIL, "新增角色失败！");
    }

    @ApiOperation("修改角色")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping
    public ResponseResult<Role> updateRole(@Valid Role role) {
        if (roleService.updateRole(role)) {
            return new ResponseResult<>(SUCCESS, "修改角色信息成功！");
        }
        return new ResponseResult<>(FAIL, "修改角色信息失败！");
    }

    @ApiOperation("删除角色")
    @ApiImplicitParam(name = "userIds", value = "角色名ID", required = true, paramType = "path", dataType = "String")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/{roleIds}")
    public ResponseResult<Integer> deleteRoleByIds(@NotNull @PathVariable("roleIds") String roleIds) {
        if (roleService.deleteRoleByIds(roleIds.split(StringConstant.COMMA))) {
            return new ResponseResult<>(SUCCESS, "删除成功！");
        }
        return new ResponseResult<>(FAIL, "删除失败！");
    }

    @ApiOperation("查询角色列表（分页）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, paramType = "path", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "页面大小", required = true, paramType = "path", dataType = "Integer")
    })
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/findRolePage/{pageNum}/{pageSize}")
    public ResponseResult<Page<Role>> findRolePage(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) {
        return new ResponseResult<>(SUCCESS, roleService.findRolePage(pageNum, pageSize));
    }
}
