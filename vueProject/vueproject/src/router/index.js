import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/Login'
import Logout from '@/components/Logout'
import Admin from '@/components/admin/AdminIndex'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/login',
      name: 'login',
      component: Login
    },
    {
      path: '/logout',
      name: 'logout',
      component: Logout,
      meta: {requireAuth: true}
    },
    {
      path: '/admin',
      name: 'admin',
      component: Admin,
      redirect: '/admin/dashboard',
      children: [
        {
          path: '/admin/dashboard',
          name: 'adminDashboard',
          component: () => import('@/components/admin/dashboard/Index')
        },
        {
          path: '/admin/user/Profile',
          name: 'adminUserProfile',
          component: () => import('@/components/admin/user/Profile')
        },
        {
          path: '/admin/user/Role',
          name: 'adminUserRole',
          component: () => import('@/components/admin/user/Role')
        },
        {
          path: '/admin/test/Test1',
          name: 'adminTest1',
          component: () => import('@/components/admin/test/Test1')
        },
        {
          path: '/admin/test/Test2',
          name: 'adminTest2',
          component: () => import('@/components/admin/test/Test2')
        }
      ]
    }
  ]
})
