package com.example.springsecurity.service.impl;

import com.example.springsecurity.entity.User;
import com.example.springsecurity.mapper.UserMapper;
import com.example.springsecurity.service.AuthService;
import com.example.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author 西云研究所
 * @date 2021/8/17
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Autowired
    private AuthService authService;

    @Override
    public User selectUserByName(String name) {
        //
            System.out.println(name);
        //
        User user = userMapper.selectUserByName(name);
        //
            System.out.println(user);
        //
        return user;

    }

    @Override
    public void addUser(String name, String pwd) {
        System.out.println("raw密码:"+ pwd);
        pwd = new BCryptPasswordEncoder().encode(pwd);
        System.out.println("新密码:"+ pwd);
        userMapper.addUser(name, pwd);
        int id = this.selectUserByName(name).getId();
        authService.addUser(id, "ROLE_admin");
    }
}
