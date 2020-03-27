<template>
  <div class="login-container">
      <el-form label-position="left"
      label-width="0px"
      status-icon>
        <h3 class="login_title">系统登录</h3>
        <el-form-item prop="account">
          <el-input
            type="text"
            v-model="username"
            auto-coplete="off"
            placeholder="账号">
          </el-input>
        </el-form-item>
        <el-form-item prop="checkPass">
          <el-input
            type="password"
            v-model="password"
            auto-coplete="off"
            placeholder="密码">
          </el-input>
        </el-form-item>
        <el-form-item style="width: 100%">
          <el-button type="primary" @click.native.prevent="login" style="width: 100%">登录</el-button>
          <el-button type="primary" @click.native.prevent="register" style="width: 100%; margin-top: 30px">注册</el-button>
        </el-form-item>
      </el-form>
  </div>
</template>

<script>
import { post } from '@/utils/http'
import axios from 'axios'
import store from '../store'
export default {
  name: 'Login',
  data () {
    return {
      username: '',
      password: ''
    }
  },
  created () {
  },
  methods: {
    login () {
      var params = {
        username: this.username,
        password: this.password
      }
      debugger
      this.$store.commit('setUserName', this.username)
      console.log(store.state.username)
      post('user/login', params).then(res => {
        debugger
        this.$store.commit('setUserToken', res) // 将返回的token存储在vuex中
        console.log(store.state.setUserToken)
        // this.$router.replace('/logout') // 路由跳转到登出界面
      }).catch((e) => {})
    },
    register () {
      let params = {
        username: this.username,
        password: this.password
      }
      debugger
      axios.post('http://localhost:9527/user/register', params).then(res => {
        console.log(res)
      })
    }
  }
}
</script>

<style scoped>
.login-container{
  border-radius: 15px;
  background-clip: padding-box;
  margin: 10% auto;
  width: 350px;
  padding: 35px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}
.login_title{
  margin: 0px auto 40px auto;
  text-align: center;
  color: #505458;
}
</style>
