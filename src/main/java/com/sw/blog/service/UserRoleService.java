package com.sw.blog.service;

import com.sw.blog.pojo.UserRole;

/**
 * @Description
 * @Author suaxi
 * @Date 2021/10/29 14:29
 */
public interface UserRoleService {

    /**
     * 新增
     * @param userRole
     * @return
     */
    boolean createUserRole(UserRole userRole);

    /**
     * 修改
     * @param userRole
     * @return
     */
    boolean updateUserRole(UserRole userRole);

    /**
     * 根据用户ID删除
     * @param userIds
     * @return
     */
    boolean deleteByUserIds(String[] userIds);

    /**
     * 根据角色ID删除
     * @param roleIds
     * @return
     */
    boolean deleteByRoleIds(String[] roleIds);
}
