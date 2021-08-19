import router from "../../router";
import {getLocalToken} from "../../utils/token";
import customAlert from "../alert/custom-alert";

router.beforeEach((to, from, next) => {
    const token = getLocalToken();
    if (token === null) {
        customAlert('登录已过期，请重新登陆', 'error');
        if (to.path === '/login') {
            next();
        } else {
            next('/login');
        }
    } else {
        next();
    }
})