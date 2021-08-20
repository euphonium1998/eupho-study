package com.example.springsecurity.filter;

import com.auth0.jwt.exceptions.JWTDecodeException;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.springsecurity.service.RedisService;
import com.example.springsecurity.utils.TokenUtils;
import com.example.springsecurity.utils.web.JsonResponse;
import com.example.springsecurity.utils.web.Status;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;

/**
 * @author 西云研究所
 * @date 2021/8/18
 */
public class TokenAuthFilter extends BasicAuthenticationFilter {
    @Autowired
    private Logger logger;

    private TokenUtils tokenUtils;
    private RedisService redisService;

    public TokenAuthFilter(AuthenticationManager authenticationManager, TokenUtils tokenUtils, RedisService redisService) {
        super(authenticationManager);
        this.tokenUtils = tokenUtils;
        this.redisService = redisService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        //从header获取token
        String token = request.getHeader("token");
        //
        System.out.println("from TokenAuthFilter: \ntoken=" + token);
        //
        try {

            DecodedJWT decodedJWT = TokenUtils.verifyToken(token);

            //从token获取用户名
            String username = decodedJWT.getClaim("userName").asString();
            //
            System.out.println(username);
            //查看用户是否登出

            String redisUserName = redisService.queryIfContainsUser(username);
            System.out.println("redis中储存的:" + redisUserName);

            redisUserName.equals("hhh");

            //从token获取对应权限列表
            String permissions = TokenUtils.verifyToken(token).getClaim("auths").asString();
            //
            System.out.println("auths:" + permissions);
            //
            String[] permissions2 = permissions.split(",");
            List<String> permissionValueList = new ArrayList<>();
            for (String permission : permissions2) {
                System.out.println(permission);
                permissionValueList.add(permission);
            }
            Collection<GrantedAuthority> authority = new ArrayList<>();
            for (String permissionValue : permissionValueList) {
                //
                System.out.println("权限:" + permissionValue);
                //
                SimpleGrantedAuthority auth = new SimpleGrantedAuthority(permissionValue);
                authority.add(auth);
            }
            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, token, authority);
            //判断如果有权限信息，放到权限上下文中
            SecurityContextHolder.getContext().setAuthentication(authRequest);
            chain.doFilter(request, response);
        } catch (TokenExpiredException e) {
            JsonResponse.responce(Status.TOKEN_EXPIRED, response);
        } catch (JWTDecodeException e) {
            JsonResponse.responce(Status.TOKEN_PARSE_ERROR, response);
        } catch (NullPointerException e) {
            JsonResponse.responce(Status.UNAUTHORIZED, response);
        }

    }
}
