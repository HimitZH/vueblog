import Vue from 'vue'
import VueRouter from 'vue-router'
Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Index',
    redirect: { name: "Blog" }
  },
  {
    path: '/blog',
    name: 'Blog',
    component: () => import('@/views/Blog.vue')
  },
  {
    path: '/register',
    name: 'Register',
    component: () => import( '@/views/register.vue')
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import('@/views/Login.vue')
  },
  {
    path: '/blog/add',
    name: 'BlogEdit',
    component: () => import('@/views/BlogEdit.vue'),
    meta:{
      requireAuth: true
    }
  },
  {
    path: '/blog/:blogId',
    name: 'BlogDetail',
    component: () => import('@/views/BlogDetail.vue')
  },
  {
    path: '/user/:username',
    name: 'User',
    component: () => import('@/views/User.vue')
  },
  {
    path: '/blog/:blogId/edit',
    name: 'BlogEdit',
    component: () => import('@/views/BlogEdit.vue'),
    meta:{
      requireAuth: true
    }
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
