<template>
   <div>
    <!-- <input type="text" class="mb-sm-2" id="email" name="pid" placeholder="Enter id" value="" v-model="user.id"><br>
	<input type="password" class="mb-sm-2" placeholder="Enter password" value="" v-model="user.pw"><br>
    <b-button variant="primary" v-on:click="login">Login</b-button> -->
    <div>현재온도 {{temp}}</div>
    <div>{{country}}</div>
    <div>습도{{humidity}}</div>
    <div>날씨 {{weather_main}}</div>
    <div>바람 속도 {{wind_speed}}m/s</div>
    <div>구름량 {{clouds_all}}</div>

    
    <div id="map" ></div>
  </div>
  
  
</template>
<script>
//import common from '../http_common'
const kakao = window.kakao

export default {
    
  data () {
    return {
      obj : [],
      temp : '',
      country:'',
      humidity:'',
      weather_main:0,
      wind_speed:'',
      clouds_all:'',

      latitude:'',
      longitude:'',

      map:{}
      
    }
  },
  methods: {
    // getlatlon(latitude,longitude){
    //   this.latitude = latitude
    //   this.longitude = longitude
    // },
    //  handleGeoSucces(position){
    //     const latitude = position.coords.latitude;
    //     const longitude = position.coords.longitude;
    //     console.log(latitude+" "+longitude)
    //     this.getlatlon(latitude, longitude)
    //     common.get('/weather/' + latitude+"/"+longitude)
    //     .then((res) => {
    //       console.log(res.data)
    //       this.temp = res.data.body.main.temp,
    //       this.country = res.data.body.sys.country,
    //       this.humidity=res.data.body.main.humidity,
    //       this.weather_main=res.data.body.weather[0].main,
    //       this.wind_speed=res.data.body.wind.speed,
    //       this.clouds_all=res.data.body.clouds.all,
    //           //this.ham(this.str)
    //       this.obj = res.data
    //     })
        
    //   },
    //   ham(str){
    //     console.log("??")
    //     console.log(str)
    //   },
    //       handleGeoError(){
    //   console.log('Cant access geo location')
    // },
    // initMap() 
    // { 
    //   var container = document.getElementById('map'); 
    //   var options = 
    //   { center: new kakao.maps.LatLng(33.450701, 126.570667), level: 3 }; 
    //   var map = new kakao.maps.Map(container, options); 
    //   //마커추가하려면 객체를 아래와 같이 하나 만든다. 
    //   this.setcenter(map)
    //   }, 
    //   setcenter(map){
    //     var moveLatLon = new kakao.maps.LatLng(33.450701, 126.570667);
    //     map.setCenter(moveLatLon);
    //     var marker = new kakao.maps.Marker({ position: map.getCenter() }); 
    //   marker.setMap(map); 
    //   },
  },
  mounted(){
      var container = document.getElementById('map'); 
      var options = { 
          center: new kakao.maps.LatLng(33.450701, 126.570667), 
          level: 3 
        }; 
      this.map = new kakao.maps.Map(container, options); 
  }
}
</script>
<style scoped>
.row{
  text-align: center;
}
#map {
  width:300px;
  height:350px;
  z-index: 1;
}
</style>