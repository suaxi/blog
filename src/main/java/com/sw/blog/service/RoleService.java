package com.sw.blog.service;

import com.sw.blog.pojo.Role;

/**
 * @Description
 * @Author suaxi
 * @Date 2021/10/29 14:23
 */
public interface RoleService {

    /**
     * 根据ID查询角色
     * @param roleId
     * @return
     */
    Role findRoleById(Integer roleId);

    /**
     * 根据角色名查询角色
     * @param roleName
     * @return
     */
    Role findRoleByName(String roleName);

    /**
     * 新增
     * @param role
     * @return
     */
    boolean createRole(Role role);

    /**
     * 修改
     * @param role
     * @return
     */
    boolean updateRole(Role role);

    /**
     * 删除
     * @param roleIds
     * @return
     */
    boolean deleteRoleByIds(String[] roleIds);
}
