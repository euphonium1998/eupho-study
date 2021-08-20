package com.example.springsecurity.service.impl;

import com.example.springsecurity.entity.SecurityUser;
import com.example.springsecurity.entity.User;
import com.example.springsecurity.mapper.AuthMapper;
import com.example.springsecurity.service.AuthService;
import com.example.springsecurity.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 西云研究所
 * @date 2021/8/17
 */
@Service
public class UserDetailsImpl implements UserDetailsService {
    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据用户名查询数据
        User user = userService.selectUserByName(username);
        //判断
        if(user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        User curUser = new User();
        BeanUtils.copyProperties(user, curUser);

        //根据用户查询用户权限列表
        List<String> permissionValueList = authService.selectAuthById(user.getId());
        SecurityUser securityUser = new SecurityUser();
        securityUser.setCurrentUserInfo(curUser);
        securityUser.setPermissionValueList(permissionValueList);
        //
        System.out.println(securityUser);
        //
        return securityUser;
    }
}
