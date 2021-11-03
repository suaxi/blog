package com.sw.blog.service.impl;

import com.sw.blog.pojo.User;
import com.sw.blog.service.RoleService;
import com.sw.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 重写loadUserByUsername方法
 * @author suaxi
 * @date 2021/10/29 15:20
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userInfo = userService.findUserByName(username);
        if (userInfo == null) {
            throw new UsernameNotFoundException("用户不存在！");
        }

        String role = roleService.findRoleById(userInfo.getRoleId()).getRolename();

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        return new org.springframework.security.core.userdetails.User(
                userInfo.getUsername(),
                userInfo.getPassword(),
                authorities
        );
    }
}
