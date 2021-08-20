package com.example.springsecurity.service.impl;

import com.example.springsecurity.mapper.AuthMapper;
import com.example.springsecurity.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 西云研究所
 * @date 2021/8/17
 */
@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private AuthMapper authMapper;

    @Override
    public List<String> selectAuthById(int id) {
        List<String> auths = authMapper.selectAuthById(id);
            System.out.println(auths);
        return auths;
    }

    @Override
    public void addUser(int id, String auth) {
        authMapper.addUser(id, auth);
    }
}
