<template>
  <div class="home">
    <img alt="Vue logo" :src="image_src">
    <HelloWorld msg="Welcome to Your Vue.js App"/>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from 'resources/components/HelloWorld.vue'
import Logo from 'resources/assets/logo.png'

export default {
  name: 'home',
  data() {
    return {
      image_src: Logo
    }
  },
  components: {
    HelloWorld
  }
}
</script>
