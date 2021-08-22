import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../components/Home.vue'
import Login from '../views/Login.vue'
import UserPage from "../views/UserPage";

const originalPush = VueRouter.prototype.push

VueRouter.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err)
}

Vue.use(VueRouter)

/* 公用路由表 */
export const defaultRoutes = [
  {
    path: '/',
    redirect: '/main'
  },
  {
    path: '/login',
    component: Login
  },
  {
    path: '/main',
    name: 'index',
    component: Home
  },
  {
    path: '/404',
    component: () => import('../views/errorPages/404')
  }
]

/* 需要鉴权的路由表 */
export const asyncRoutes = [
  {
    path: '/home',
    name: 'Home',
    redirect: '/home/example',
    component: Home,
    children: [
      {
        path: 'example',
        components: {
          main: () => import('../components/Example'),
        },
        meta: {
          roles: ['admin', 'user'],
          menuName: '示例'
        },
      },
      {
        path: 'task1',
        components: {
          main: () => import('../views/demoTasks/Task1'),
        },
        meta: {
          roles: ['admin'],
          menuName: '任务1'
        },
      },
      {
        path: 'task2',
        components: {
          main: () => import('../views/demoTasks/Task2'),
        },
        meta: {
          roles: ['admin'],
          menuName: '任务2'
        },
      },
      {
        path: 'task3',
        components: {
          main: () => import('../views/demoTasks/Task3'),
        },
        meta: {
          roles: ['admin', 'user'],
          menuName: '任务3'
        },
      },
      {
        path: 'task4',
        components: {
          main: () => import('../views/demoTasks/Task4'),
        },
        meta: {
          roles: ['admin', 'user'],
          menuName: '任务4'
        },
      },
      {
        path: 'task5',
        components: {
          main: () => import('../views/demoTasks/Task5'),
        },
        meta: {
          roles: ['user'],
          menuName: '任务5'
        },
      },
      {
        path: 'task6',
        components: {
          main: () => import('../views/demoTasks/Task6'),
        },
        meta: {
          roles: ['user'],
          menuName: '任务6'
        },
      },
      {
        path: 'user',
        components: {
          main: UserPage
        },
        sidebarHidden: true,
        meta: {
          roles: ['user'],
        },
      },
    ]
  },
  /* 404 的路由一定要放在最后 */
  {
    path: '*',
    redirect: '/404',
    hidden: true
  }

]


const router = new VueRouter({
  mode: 'history',
  routes: defaultRoutes // 初始只挂载公用默认路由
})

export default router
