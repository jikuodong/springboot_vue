<template>
    <div>
        <el-button @click="logout">登出</el-button>
    </div>
</template>

<script>
import { post } from '@/utils/http'
export default {
  name: 'Logout',
  data () {
    return {}
  },
  computed: {},
  watch: {},
  methods: {
    logout () {
      post('user/logout').then(res => {
        this.$store.commit('logout') // 清除store的内容
        this.$router.replace('/login')
      })
    }
  }
}
</script>

<style scoped>

</style>
