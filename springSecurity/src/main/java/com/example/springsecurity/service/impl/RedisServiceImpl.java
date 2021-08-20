package com.example.springsecurity.service.impl;

import com.example.springsecurity.mapper.RedisUserMapper;
import com.example.springsecurity.service.RedisService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 西云研究所
 * @date 2021/8/17
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisUserMapper redisUserMapper;

    @Override
    public void addRedisUser(String name) {
        redisUserMapper.addRedisUser(name);
    }

    @Override
    public void deleteRedisUser(String name) {
        System.out.println("RedisService删除用户:"+name);
        redisUserMapper.deleteRedisUser(name);
    }

    @Override
    public String queryIfContainsUser(@Param("name")String name){
        return redisUserMapper.queryIfContainsUser(name);
    };
}
