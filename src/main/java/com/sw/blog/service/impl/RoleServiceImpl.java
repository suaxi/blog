package com.sw.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sw.blog.mapper.RoleMapper;
import com.sw.blog.pojo.Role;
import com.sw.blog.service.RoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

/**
 * @description
 * @author suaxi
 * @date 2021/10/29 14:13
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Override
    public Role findRoleById(Integer roleId) {
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(String.valueOf(roleId))) {
            queryWrapper.lambda().eq(Role::getRoleId, roleId);
        }
        return this.baseMapper.selectOne(queryWrapper);
    }

    @Override
    public Role findRoleByName(String roleName) {
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(roleName)) {
            queryWrapper.lambda().like(Role::getRolename, roleName);
        }
        return this.baseMapper.selectOne(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean createRole(Role role) {
        return this.save(role);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateRole(Role role) {
        return this.updateById(role);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteRoleByIds(String[] roleIds) {
        return this.removeByIds(Arrays.asList(roleIds));
    }

    @Override
    public Page<Role> findRolePage(Integer pageNum, Integer pageSize) {
        return this.baseMapper.selectPage(new Page<>(pageNum, pageSize), new QueryWrapper<>());
    }
}
