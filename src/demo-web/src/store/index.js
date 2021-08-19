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
    msgbar,
    user

  }
})
