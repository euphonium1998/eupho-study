package com.example.springsecurity.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 西云研究所
 * @date 2021/8/17
 */
public interface RedisService {
    public void addRedisUser(String namet);

    public void deleteRedisUser(String name);

    public String queryIfContainsUser(@Param("name")String name);
}
