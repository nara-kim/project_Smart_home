import Vue from 'vue'
import App from './App.vue'
import './plugins/element.js'
import router from './router'
import BootstrapVue from 'bootstrap-vue/dist/bootstrap-vue.esm'
import store from "./store";
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

import { BootstrapVueIcons } from 'bootstrap-vue'

Vue.use(BootstrapVueIcons)
Vue.use(BootstrapVue)
Vue.config.productionTip = false


new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
