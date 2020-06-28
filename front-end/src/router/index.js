import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import SignUp from '../views/SignUp.vue'
import Login from '../views/Login.vue'
import Weather from '../views/Weather.vue'
import Aircon from '../views/Aircon.vue'
import Blind from '../views/Blind.vue'
import Myhome from '../views/Myhome.vue'
import Light from '../views/Light.vue'

Vue.use(VueRouter)

  const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  // {
  //   path: '/about',
  //   name: 'About',
  //   // route level code-splitting
  //   // this generates a separate chunk (about.[hash].js) for this route
  //   // which is lazy-loaded when the route is visited.
  //   component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  // },
  {
    path: '/signup',
    name: 'Signup',
    component: SignUp
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/Weather',
    name: 'Weather',
    component: Weather
  },
  {
    path: '/Aircon',
    name: 'Aircon',
    component: Aircon
  },
  {
    path: '/Blind',
    name: 'Blind',
    component: Blind
  },
  {
    path: '/Myhome',
    name: 'Myhome',
    component: Myhome
  },
  {
    path: '/Light',
    name: 'Light',
    component: Light
  }
]

const router = new VueRouter({
  routes
})

export default router
