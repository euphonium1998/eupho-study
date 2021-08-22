import request from "../../utils/request";
import {getLocalToken, parseToken} from "../../utils/token";

/**
 * 发送登录请求
 * @param usernameOrEmailOrPhone
 * @param password
 * @param rememberMe
 * @returns {AxiosPromise}
 */
export function login(usernameOrEmailOrPhone, password, rememberMe) {
    return request({
        url: '/demo/api/auth/login',
        method: 'post',
        data: {
            usernameOrEmailOrPhone,
            password,
            rememberMe
        }
    })
}

/**
 * 发送登出请求
 * @returns {AxiosPromise}
 */
export function logout() {
    return request({
        url: '/demo/api/auth/logout',
        method: 'post'
    })
}

/**
 * 拉取用户信息（后端接口未写好，暂未使用）
 * @returns {AxiosPromise}
 */
export function getUserInfo() {
    return request({
        url: '/demo/api/user/getInfo',
        method: 'get'
    })
}

/**
 * 获取用户角色
 * 因拉取用户接口未写好，此处暂且使用直接从本地Token中解析用户角色的方法（不安全）
 * @returns string 用户角色字符串，如'admin'
 */
export function getRole() {
    const encodedToken = getLocalToken();
    if (!encodedToken) {
        return null;
    }
    return parseToken(encodedToken).payload.roles[0];
}

