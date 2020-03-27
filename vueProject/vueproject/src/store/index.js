import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)
// const key = 'user'
const store = new Vuex.Store({
  state: {
    username: window.localStorage.getItem('user' || '[]') == null ? '' : JSON.parse(window.localStorage.getItem('user' || '[]')).username,
    token: ''
  },
  mutations: {
    setUserName (state, username) {
      state.username = username
    },
    setUserToken (state, token) {
      state.token = token
    },
    logout (state, token) {
      state.username = null
      state.token = ''
      window.localStorage.removeItem('user')
    }
  }
})
export default store
