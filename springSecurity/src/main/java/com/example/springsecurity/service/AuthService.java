package com.example.springsecurity.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 西云研究所
 * @date 2021/8/17
 */
public interface AuthService {
    public List<String> selectAuthById(@Param("id")int id);

    public void addUser(@Param("user_id")int id, @Param("auth")String auth);
}
