<!--  -->
<template>
  <div>
    <el-menu router default-active="/admin/dashboard" mode="vertical" :collapse="isCollapse">
      <template v-for="(item,i) in adminMenus">
        <el-submenu :key="i" :index="i + ''" style="text-align: left">
          <span slot="title">
              <i :class="item.iconCls" style="font-size:10px"></i>
            {{item.nameZh}}
          </span>
          <el-menu-item v-for="child in item.children" :key="child.path" :index="child.path">
            <i :class="child.icon"></i>
            {{ child.nameZh }}
          </el-menu-item>
        </el-submenu>
      </template>
    </el-menu>
  </div>
</template>

<script>
export default {
  data () {
    return {
      isCollapse: false
      // adminMenus: [
      //   {
      //     iconCls: 'el-icon-s-home',
      //     nameZh: '首页',
      //     children: [
      //       {
      //         icon: '',
      //         nameZh: '首页1-1',
      //         path: '/admin/user/Profile'
      //       }
      //     ]
      //   }
      // ]
    }
  },
  computed: {
    adminMenus () {
      debugger
      return this.$store.state.adminMenus
    }
  }
}
</script>
