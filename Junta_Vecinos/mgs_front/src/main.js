import Vue from 'vue';
import Vuex from 'vuex';
import App from './App.vue';
import router from './router';
import store from './store';
import * as VeeValidate from 'vee-validate';
import Notifications from 'vue-notification'
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap-vue/dist/bootstrap-vue.css';
import '@/assets/css/main.css';
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue';

Vue.use(Vuex);
Vue.use(VeeValidate);
Vue.use(BootstrapVue);
Vue.use(IconsPlugin);
Vue.use(Notifications);

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
