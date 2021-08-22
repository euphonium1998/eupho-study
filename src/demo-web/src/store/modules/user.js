import {removeLocalToken, setLocalToken} from "../../utils/token";
import {getRole, login, logout} from "../../api/auth/user";
import {filterAsyncRoutes} from "../../api/auth/permission";
import router, {asyncRoutes, defaultRoutes} from '../../router/index'


const user = {

    namespaced: true,

    state: {
        username: '',
        role: null,
        permittedRouteList: []
    },

    mutations: {
        SET_TOKEN: (state, token) => {
            state.token = token;
        },
        SET_USERNAME: (state, username) => {
            state.username = username;
        },
        SET_ROLE: (state, role) => {
            state.role = role;
        },
        REMOVE_ROLE: (state) => {
            state.role = null;
        },
        SET_ROUTE_LIST: (state, permittedRouteList) => {
            state.permittedRouteList = permittedRouteList;
        },
        REMOVE_ROUTE_LIST: (state) => {
            state.permittedRouteList = [];
        }
    },

    actions: {
        login({commit}, userLoginInfo) {
            const {usernameOrEmailOrPhone, password, rememberMe} = userLoginInfo;
            return new Promise((resolve, reject) => {
                login(usernameOrEmailOrPhone, password, rememberMe).then((resp) => {
                    /**
                     * 因为后端无论账号密码是否正确都会返回给到response，
                     * 从而这个login的回调函数无论如何都会被触发
                     * 而且在这个地方axios对于response的拦截似乎不起作用，所以需要在这里手动拦截
                     * 如果返回的自定义响应码不是200就说明登录失败
                     * 然后将后端返回的响应message作为err，手动reject
                     */
                    console.log(resp);
                    if (resp.data.code !== 200) {
                        reject(resp.data.message);
                    } else {
                        const recvToken = resp.data.data.token;
                        setLocalToken(recvToken);
                        commit('SET_ROLE', getRole());
                        resolve();
                    }
                }).catch(error => {
                    reject(error);
                })
            })
        },
        logout({commit}) {
            return new Promise((resolve, reject) => {
                logout().then((resp) => {
                    console.log(resp); // for debug
                    removeLocalToken();
                    commit('REMOVE_ROLE');
                    commit('REMOVE_ROUTE_LIST');
                    resolve();
                }).catch(err => {
                    reject(err);
                })
            })
        },
        getRole({commit}) {
            commit('SET_ROLE', getRole());
        },
        getPermittedRouteList({commit}, roleType) {
            return new Promise(resolve => {
                let filteredRoutes = filterAsyncRoutes(asyncRoutes, roleType);
                let completeRouteList = defaultRoutes.concat(filteredRoutes);
                commit('SET_ROUTE_LIST', completeRouteList);
                router.addRoutes(completeRouteList);
                resolve();
            })
        }
    }
}

export default user;