import {getLocalToken, setLocalToken} from "../../utils/token";
import {login} from "../../api/auth/user";
import customAlert from "../../api/alert/custom-alert";

const user = {

    namespaced: true,

    state: {
        token: getLocalToken(),
        username: '',
        roles: []
    },

    mutations: {
        SET_TOKEN: (state, token) => {
            state.token = token;
        },
        SET_USERNAME: (state, username) => {
            state.username = username;
        },
        SET_ROLES: (state, roles) => {
            state.roles = roles;
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
                    if (resp.data.code !== 200) {
                        reject(resp.data.message);
                    } else {
                        const recvToken = resp.data.data.token;
                        setLocalToken(recvToken);
                        commit('SET_TOKEN', recvToken);
                        resolve();
                    }
                }).catch(error => {
                    reject(error);
                })
            })
        }
    }
}

export default user;