import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import axios from "axios"; // 主要是这里，引入配置好的Api
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

const app = createApp(App);
app.config.globalProperties.$axios = axios; // 方法挂载到全局
app.use(store).use(router).use(ElementPlus).mount("#app");

