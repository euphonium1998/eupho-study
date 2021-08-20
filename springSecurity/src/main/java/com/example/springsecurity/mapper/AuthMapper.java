package com.example.springsecurity.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 西云研究所
 * @date 2021/8/17
 */
@Mapper
public interface AuthMapper {
    public List<String> selectAuthById(@Param("id")int id);

    public void addUser(@Param("id")int id, @Param("auth")String auth);
}
