package com.sw.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sw.blog.pojo.User;

/**
 * @description
 * @author suaxi
 * @date 2021/10/29 14:10
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

    /**
     * 查询用户列表（分页）
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<User> findUserPage(int pageNum ,int pageSize);

    /**
     * 修改密码
     * @param userId
     * @param password
     * @return
     */
    boolean updatePassword(Integer userId, String password);

}
