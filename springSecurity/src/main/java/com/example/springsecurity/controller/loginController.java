package com.example.springsecurity.controller;

import com.example.springsecurity.entity.User;
import com.example.springsecurity.service.AuthService;
import com.example.springsecurity.service.RedisService;
import com.example.springsecurity.service.UserService;
import com.example.springsecurity.utils.TokenUtils;
import com.example.springsecurity.utils.web.ApiResponse;
import com.example.springsecurity.utils.web.JwtResponse;
import com.example.springsecurity.utils.web.Status;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 西云研究所
 * @date 2021/8/17
 */
@RestController
@RequestMapping
public class loginController {

    @Autowired
    private RedisService redisService;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;
    /**
     * 添加
     */
    @PostMapping("/add")
    public void addUser(@Param("name")String name, @Param("pwd") String pwd) {
        userService.addUser(name, pwd);
    }

    /*
    *测试登录
     */
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_admin')")
    public String admin(){
        return "hello admin用户!";
    }

    @GetMapping("/stu")
    @PreAuthorize("hasRole('ROLE_stu')")
    public String stu(){
        return "hello stu用户!";
    }

    /**
     * 登录
     */
    @GetMapping("/login")
    public ApiResponse login(@Param("name")String name, @Param("pwd")String pwd) {
        //认证成功，得到认证成功之后用户信息
        //SecurityUser user = new SecurityUser();
        System.out.println("name:"+ name);
        System.out.println("rawpwd:"+pwd);
        String encodedPwd = new BCryptPasswordEncoder().encode(pwd);
        System.out.println("encoodedPwd"+ encodedPwd);
        User userDB = userService.selectUserByName(name);
        if(userDB == null|| !new BCryptPasswordEncoder().matches(pwd, userDB.getPwd())){
            return ApiResponse.ofStatus(Status.USERNAME_PASSWORD_ERROR);
        }
        //根据用户名和权限生成token
        Map map = new HashMap<String, String>();
        map.put("userName", name);
        //
        System.out.println("以下处理来自LoginController:");
        //

        List<String> permissionValueList = authService.selectAuthById(userDB.getId());
        String auths = "";
        for(String permission : permissionValueList){
            auths += permission+",";
        }
        map.put("auths", auths);
        String token = TokenUtils.createToken(map);

        //
        System.out.println("From TokenLoginFilter:" + token);
        //

        //把用户名称放到redis
        redisService.addRedisUser(userDB.getName());
        //返回token
        return ApiResponse.ofSuccess(new JwtResponse(token));
    }

    /*
    登出
     */
    @PostMapping("/logout")
    public ApiResponse logout(@Param("name")String name){
        redisService.deleteRedisUser(name);
        return ApiResponse.ofStatus(Status.LOGOUT);
    }
}
