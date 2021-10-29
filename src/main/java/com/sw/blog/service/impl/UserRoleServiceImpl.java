package com.sw.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sw.blog.mapper.UserRoleMapper;
import com.sw.blog.pojo.UserRole;
import com.sw.blog.service.UserRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

/**
 * @Description
 * @Author suaxi
 * @Date 2021/10/29 14:31
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean createUserRole(UserRole userRole) {
        return this.save(userRole);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateUserRole(UserRole userRole) {
        return this.saveOrUpdate(userRole);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteByUserIds(String[] userIds) {
        return this.removeByIds(Arrays.asList(userIds));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteByRoleIds(String[] roleIds) {
        return this.removeByIds(Arrays.asList(roleIds));
    }
}
