import Vue from 'vue'
import Vuex from 'vuex'
import msgbar from "./modules/msgbar"
import user from "./modules/user";

Vue.use(Vuex)

export default new Vuex.Store({
  state: {},
  mutations: {},
  actions: {},
  modules: {
    msgbar, // 全局消息条
    user    // 用户全局状态模块
  }
})
