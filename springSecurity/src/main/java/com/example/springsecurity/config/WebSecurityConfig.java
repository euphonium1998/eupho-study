package com.example.springsecurity.config;

import com.example.springsecurity.filter.TokenAuthFilter;
import com.example.springsecurity.service.RedisService;
import com.example.springsecurity.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author 西云研究所
 * @date 2021/8/17
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private TokenUtils tokenUtils;
    private RedisService redisService;
    private UserDetailsService userDetailsService;

    @Autowired
    public WebSecurityConfig(UserDetailsService userDetailsService, TokenUtils tokenUtils, RedisService redisService) {
        this.userDetailsService = userDetailsService;
        this.tokenUtils = tokenUtils;
        this.redisService = redisService;
    }

    /**
     * 配置设置
     * @param http
     * @throws Exception
     */
    //设置退出的地址和token，redis操作地址
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling()
                //.authenticationEntryPoint(new UnauthEntryPoint())//没有权限访问
                .and().csrf().disable()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and().logout().disable()
                //.addFilter(new TokenLoginFilter(authenticationManager(), tokenUtils, redisService))
                .addFilter(new TokenAuthFilter(authenticationManager(), tokenUtils, redisService)).httpBasic();
        //http.addFilterBefore(new TokenLoginFilter(authenticationManager(), tokenUtils, redisService), UsernamePasswordAuthenticationFilter.class);
    }

    //调用userDetailsService和密码处理
    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
    }
    //不进行认证的路径，可以直接访问
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/add","/login");
    }
}
