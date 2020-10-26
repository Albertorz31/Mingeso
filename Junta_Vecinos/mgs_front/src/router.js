import Vue from 'vue'
import VueRouter from 'vue-router'
//import Home from '../views/Home.vue'

Vue.use(VueRouter)

  const routes = [
  {
    path: '/',
    name: 'Dashboard',
    component: () => import('./views/Dashboard.vue')
  },
  {
    path: '/home',
    name: 'Home',
    component: () => import('./views/Home.vue')
  },
  {
    path: '/about',
    name: 'About',
    component: () => import('./views/About.vue')
  },
  {
    path: '/singup',
    name: 'Singup',
    component: () => import('./views/Singup.vue')
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import('./views/Login.vue')
  },
  {
    path: '/forgot-password',
    name: 'ForgotPassword',
    component: () => import('./views/ForgotPassword.vue')
  },
  {
   path: '/create-post',
   name: 'CreatePost',
   component: () => import('./views/CreatePost.vue')
  },
  {
    path: '/announcement-feed',
    name: 'AnnouncementFeed',
    component: () => import('./views/AnnouncementFeed')
  },
  {
    path: '/homecitizen',
    name: 'HomeCitizen',
    component: () => import('./views/HomeCitizen.vue')
  },
  {
    path: '/usersList',
    name: 'UserList',
    component: () => import('./views/UserList.vue')
  },
  {
    path: '/verRanking',
    name: 'VerRanking',
    component: () => import('./views/VerRanking.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
