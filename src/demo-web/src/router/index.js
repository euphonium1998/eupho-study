import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../components/Home.vue'

const originalPush = VueRouter.prototype.push

VueRouter.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err)
}

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect: '/home',
  },
  {
    path: '/home',
    name: 'Home',
    redirect: '/home/example',
    component: () => import('../components/Home'),
    children: [
      {
        path: 'example',
        components: {
          main: () => import('../components/Example'),
        },
      },
      {
        path: 'task1',
        components: {
          main: () => import('../components/Task1'),
        },
      },
      {
        path: 'task2',
        components: {
          main: () => import('../components/Task2'),
        },
      },
      {
        path: 'task3',
        components: {
          main: () => import('../components/Task3'),
        },
      },
      {
        path: 'task4',
        components: {
          main: () => import('../components/Task4'),
        },
      },
      {
        path: 'task5',
        components: {
          main: () => import('../components/Task5'),
        },
      },
      {
        path: 'task6',
        components: {
          main: () => import('../components/Task6'),
        },
      },
    ]
  },

]

const router = new VueRouter({
  mode: 'history',
  routes
})

export default router
