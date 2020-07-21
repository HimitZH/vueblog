import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import Element from 'element-ui'
import "element-ui/lib/theme-chalk/index.css"
import axios from 'axios'
import mavonEditor from 'mavon-editor'
import'mavon-editor/dist/css/index.css'

import './axios'
import './permisssion'

Vue.config.productionTip = false
Vue.use(Element)
Vue.use(mavonEditor)
Vue.prototype.$axios = axios

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
