<template>
  <div class="container">
    <b-button variant="primary" v-on:click="getdata">getdata</b-button>
    {{datas}}
  </div>
</template>

<script>
import common from '../http_common'
export default {
  data(){
    return {
      datas:'',
    }
  },
  methods:{
    getdata: function(){
      common.get('/getdata')
        .then((res)=>{
          this.datas = res.data
        })
    }
  }
}
</script>


<style scoped>


</style>
