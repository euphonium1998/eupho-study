import request from "../../utils/request";
import {getLocalToken, parseToken} from "../../utils/token";

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

export function logout() {
    return request({
        url: '/demo/api/auth/logout',
        method: 'post'
    })
}

export function getRoles() {
    const encodedToken = getLocalToken();
    return parseToken(encodedToken).payload["roles"];
}
