<template>
  <div class="container">
    <div class="row">
        <div class="col-4">
          <img src="../img/light.png" style="width:80%">
          <div>Brightness</div>
          <h3>70</h3>
        </div>
        <div class="col-4">
          <img src="../img/temperature.png" style="width:80%">
          <div>Temperature</div>
          <h3>{{strArray[0]}}</h3>
          {{datas}}
        </div>
        <div class="col-4">
          <img src="../img/humidity.png" style="width:80%">
          <div>Humidity</div>
          <h3>{{strArray[1]}}%</h3>
        </div>
    </div>
  </div>
</template>

<script>
import common from '../http_common'
export default {
  data(){
    return {
      strArray:[],
    }
  },
  methods:{
    getdata: function(){
        common.get('/getdata')
          .then((res)=>{
            this.strArray = res.data.split(" ");
          })
      },
  },
  mounted(){
    console.log("==========")
    this.getdata()
  }
}
</script>


<style scoped>
</style>
