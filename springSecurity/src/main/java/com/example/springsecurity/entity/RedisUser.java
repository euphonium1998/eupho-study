package com.example.springsecurity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 西云研究所
 * @date 2021/8/17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RedisUser {
    private String name;
    private List<String> permissionValueList;
}
