<template>
  <div class="home" align="center">
    <img alt="Vue logo" src="../assets/logo.png">
    <HelloWorld msg="Welcomee! to Your Vue.js App"/>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'Home',
  components: {
    HelloWorld
  }
}
</script>
