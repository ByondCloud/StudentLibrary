<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App"/>
  </div>
</template>

<script>
import HelloWorld from '@/components/HelloWorld.vue'
import axios from "axios";


export default {
  name: 'HomeView',
  components: {
    HelloWorld
  },
  methods: {

  }
}


</script>
