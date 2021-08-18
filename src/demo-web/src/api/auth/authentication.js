import request from "../../utils/request";

export default {
    login(usernameOrEmailOrPhone, password, rememberMe) {
        return request({
            url: '/demo/api/auth/login',
            method: 'post',
            data: {
                usernameOrEmailOrPhone,
                password,
                rememberMe
            }
        })
    },
    logout() {
        return request({
            url: '/demo/api/auth/logout',
            method: 'post'
        })
    }
}
