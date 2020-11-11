<template>
  <div class="home">
    <Myhome/>
    <Control/>
  </div>
</template>

<script>
// @ is an alias to /src
import Control from '@/components/Control.vue'
import Myhome from '@/components/Myhome.vue'
export default {
  name: 'Home',
  components: {
    Control,
    Myhome
  }
  
}
</script>
