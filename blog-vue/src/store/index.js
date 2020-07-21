import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    token: '',
    userInfo: JSON.parse(sessionStorage.getItem("userInfo"))
  },
  mutations: {
    setToken:(state,token)=>{
      state.token = token
      localStorage.setItem("token",token)
    },
    setUserInfo:(state,userInfo)=>{
      state.userInfo = userInfo
      sessionStorage.setItem("userInfo",JSON.stringify(userInfo))
    },
    rmUserInfo:(state)=>{
      state.token = ''
      state.userInfo = {}
      localStorage.setItem("token",'')
      sessionStorage.setItem("userInfo",JSON.stringify(''))
    }
  },
  getters: {
    getUserInfo:state => {
      return state.userInfo;
    }
  },
  actions: {
  },
  modules: {
  }
})
