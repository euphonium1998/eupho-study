package com.example.springsecurity.service;

import com.example.springsecurity.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

/**
 * @author 西云研究所
 * @date 2021/8/17
 */
public interface UserService {
    public User selectUserByName(@Param("name") String name);

    public void addUser(@Param("name")String name, @Param("pwd")String pwd);
}
