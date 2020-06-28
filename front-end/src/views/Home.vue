<template>
  <div class="home">
    <Myhome/>
    <HelloWorld />
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
import Myhome from '@/components/Myhome.vue'
export default {
  name: 'Home',
  components: {
    HelloWorld,
    Myhome
  }
  
}
</script>
