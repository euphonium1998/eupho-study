import router, {asyncRoutes} from "./index";
import {getLocalToken} from "../utils/token";
import customAlert from "../api/alert/custom-alert";
import store from '../store'

router.beforeEach((to, from, next) => {

    const token = getLocalToken();

    if (token) {
        if (to.path === '/login') {
            next();
        } else {
            if (to.meta && to.meta.roles) {
                const role = store.state.user.role;
                if (role !== null) {
                    if (to.meta.roles.includes(role)) {
                        next();
                    } else {
                        next({path: '/404'});
                    }
                } else {
                    customAlert('无法识别角色，请重新登录');
                    next({path: '/login'});
                }
            } else {
                next();
            }
        }
    } else {
        customAlert('登录已过期，请重新登陆', 'error');
        if (to.path === '/login') {
            next();
        } else {
            next('/login');
        }
    }
})