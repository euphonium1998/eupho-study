package com.example.springsecurity.mapper;

import com.example.springsecurity.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 西云研究所
 * @date 2021/8/17
 */
@Mapper
public interface UserMapper {
    public User selectUserByName(@Param("name") String name);

    public void addUser(@Param("name")String name, @Param("pwd")String pwd);
}
