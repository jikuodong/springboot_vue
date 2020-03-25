<template>
  <div class="login-container">
    二维码信息：{{input1}}
    <el-input
      placeholder="请输入内容"
      type="textarea"
      @keydown.native.enter="changeData"
      v-focus
      v-model="input1">
    </el-input>
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
        </el-form-item>
      </el-form>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'Login',
  data () {
    return {
      username: '',
      password: '',
      input1: ''
    }
  },
  created () {
    this.changfouce()
  },
  directives: {
    focus: {
      inserted: function (el) {
        el.children[0].focus()
      }
    }
  },
  methods: {
    changfouce () {
      this.$nextTick((x) => { // 正确写法
        this.$refs.inputs.focus()
      })
    },
    changeData () {
      debugger
      console.log(this.input1)
      let input2 = this.input1.split(';')
      for (let i = 0; i < input2.length; i++) {
        console.log(input2[i])
      }
      this.input1 = ''
    },
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
