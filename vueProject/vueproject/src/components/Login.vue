<template>
  <div>
    用户名: <input v-model="username"><br>
    密码: <input type="password" v-model="password"><br>
    <button @click="login">登录</button>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'Login',
  data () {
    return {
      username: '',
      password: ''
    }
  },
  methods: {
    login () {
      var params = {
        userName: this.username,
        password: this.password
      }
      debugger
      axios.post('http://localhost:9527/user/login', params).then(res => {
        console.log(res)
      }).catch(function (e) {
        console.log(e)
      })
    }
  }
}
</script>

<style scoped>

</style>
