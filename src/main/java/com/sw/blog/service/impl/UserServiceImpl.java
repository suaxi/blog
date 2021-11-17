package com.sw.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sw.blog.constant.StringConstant;
import com.sw.blog.mapper.UserMapper;
import com.sw.blog.pojo.User;
import com.sw.blog.pojo.UserRole;
import com.sw.blog.service.UserRoleService;
import com.sw.blog.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

/**
 * @description
 * @author suaxi
 * @date 2021/10/29 14:13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public User findUserByName(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(username)) {
            queryWrapper.lambda().like(User::getUsername, username);
        }
        return this.baseMapper.selectOne(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        boolean flag = this.save(user);
        if (flag) {
            UserRole userRole = new UserRole();
            userRole.setUserId(user.getUserId());
            userRole.setRoleId(user.getRoleId());
            userRoleService.createUserRole(userRole);
        }
        return flag;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        boolean flag = this.updateById(user);
        if (flag) {
            userRoleService.deleteByUserIds(String.valueOf(user.getUserId()).split(StringConstant.COMMA));
            UserRole userRole = new UserRole();
            userRole.setUserId(user.getUserId());
            userRole.setRoleId(user.getRoleId());
        }
        return flag;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteUserByIds(String[] userIds) {
        userRoleService.deleteByUserIds(userIds);
        return this.removeByIds(Arrays.asList(userIds));
    }

    @Override
    public Page<User> findUserPage(Integer pageNum, Integer pageSize) {
        return this.baseMapper.selectPage(new Page<>(pageNum, pageSize), new QueryWrapper<>());
    }

    @Override
    public boolean updatePassword(Integer userId, String password) {
        User user = new User();
        user.setUserId(userId);
        user.setPassword(passwordEncoder.encode(password));
        return updateById(user);
    }

}
