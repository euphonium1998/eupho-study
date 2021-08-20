package com.example.springsecurity.utils.web;

import com.sun.deploy.net.HttpResponse;
import net.minidev.json.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 西云研究所
 * @date 2021/8/20
 */
public class JsonResponse {
    public static void responce(Status status, HttpServletResponse response) throws IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setContentType("application/json;charset=UTF-8");
        Map map = new HashMap<String, Object>();
        map.put("code", status.getCode());
        map.put("message", status.getMessage());
        String s = JSONObject.toJSONString(map);
        response.getWriter().write(s);
        response.setStatus(200);
    }
}
