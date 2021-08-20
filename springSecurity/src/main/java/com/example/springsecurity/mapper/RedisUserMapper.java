package com.example.springsecurity.mapper;

import com.example.springsecurity.entity.RedisUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 西云研究所
 * @date 2021/8/17
 */
@Mapper
public interface RedisUserMapper {
    public void addRedisUser(@Param("name") String name);

    public void deleteRedisUser(@Param("name")String name);

    public String queryIfContainsUser(@Param("name")String name);
}
