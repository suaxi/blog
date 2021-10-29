package com.sw.blog.service;

import com.sw.blog.pojo.User;

/**
 * @Description
 * @Author suaxi
 * @Date 2021/10/29 14:10
 */
public interface UserService {

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    User findUserByName(String username);

    /**
     * 新增
     * @param user
     * @return
     */
    boolean createUser(User user);

    /**
     * 修改
     * @param user
     * @return
     */
    boolean updateUser(User user);

    /**
     * 删除
     * @param userIds
     * @return
     */
    boolean deleteUserByIds(String[] userIds);
}
