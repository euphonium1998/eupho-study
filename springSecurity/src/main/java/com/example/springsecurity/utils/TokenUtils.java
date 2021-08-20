package com.example.springsecurity.utils;

/**
 * @author 西云研究所
 * @date 2021/8/17
 */


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.springsecurity.utils.web.ApiResponse;
import com.example.springsecurity.utils.web.Status;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.Map;

@Repository
public class TokenUtils {

    private static final String salt = "cuoiascb@1pownccpoas";

    /**
     * create token
     */
    public static String createToken(Map<String, String> map){
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, 7);//默认7天过期

        JWTCreator.Builder builder = JWT.create();

        //header 使用默认值,不写

        //payload
        map.forEach((k, v)->{
            builder.withClaim(k, v);
        });
        //过期时间
        String token = builder.withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(salt));

        return token;
    }


    /*
    * decode token
    * */
    public static DecodedJWT verifyToken(String token) throws JWTVerificationException {
        System.out.println("token工具类开始解码:"+token);
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(salt)).build().verify(token);
        return verify;
    }
}