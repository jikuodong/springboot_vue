// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import store from './store'
import initAdminMenu from '@/utils/initAdmin'
Vue.use(ElementUI)
Vue.prototype.$axios = axios
Vue.config.productionTip = false

router.beforeEach((to, from, next) => {
  if (store.state.username && (to.name === 'adminDashboard')) {
    axios.get('/user/getAuth').then(resp => {
      initAdminMenu(router, store)
    })
  }
  if (to.meta.requireAuth) { // 如果目标路由需要认证
    axios.get('/user/getAuth').then(result => { // 向后端请求当前用户的状态
      debugger
      if (result.data.code === 200) {
        next()
      } else {
        alert('您还未登录')
        next({
          path: '/login'
        })
      }
    })
  } else {
    next()
  }
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
