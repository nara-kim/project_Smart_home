<template>
  <div class="container" id="parent">
      <div class="child">
    <b-collapse id="collapse" is-nav="is-nav">
      <!-- <vue-daum-map
      :appKey="appKey"
      :center.sync="center"
      :level.sync="level"
      :mapTypeId="mapTypeId"
      :libraries="libraries"
      @load="onLoad"
      style="width:350px; height:200px;"
      /> -->
      <div id="map" style="width:350px; height:200px;">
      </div>
      <div>
      </div>
    </b-collapse>
    </div>
  </div>
</template>
<script>
    import {mapMutations, mapState} from "vuex";
    // import VueDaumMap from 'vue-daum-map'
    import common from '../http_common'
    export default {
        props: {
            opened: {
                type: Boolean,
                default: false
            }
        },
        components: {
          //VueDaumMap
        },
        data: () => ({
          // appKey:'9ae8801c00947daec17da2217ee254a7',// 테스트용 appkey
          // center: {lat:33.450701, lng:126.570667}, // 지도의 중심 좌표
          // level: 3, // 지도의 레벨(확대, 축소 정도),
          // mapTypeId: VueDaumMap.MapTypeId.NORMAL, // 맵 타입
          // libraries: [], // 추가로 불러올 라이브러리
          // map: null, // 지도 객체. 지도가 로드되면 할당됨.
          obj: {},
          latitude: '',
          longitude: '',
        }),
        methods: {
          ...mapMutations("app", ["setDrawer"]),

          getlatlon(latitude, longitude){
            this.latitude = latitude
            this.longitude = longitude
          },
          async handleGeoSucces(position){
            console.log("연날기 여기까지 옴 test ok => 백엔드거침");
            const latitude = position.coords.latitude;
            const longitude = position.coords.longitude;
            this.getlatlon(latitude, longitude)
            console.log("확인차" + latitude +"/" + longitude);
            common.get('/weather/' + latitude + "/" + longitude)
            .then(res =>{
              console.log("여기냐 혹시? => test ok");
              console.log(res.data)
              this.obj = res.data
            })
          },
          ham(str){
            console.log(str)
          },
          handleGeoError(){
            console.log('Can`t access geo location')
            console.log("강소강소");
          },
          initMap(){
            var container = document.getElementById('map');
            var options = {
              center: new kakao.maps.LatLng(33.450701, 126.570667), level: 3 
            };
            var map = new kakao.maps.Map(container, options);
            this.setcenter(map)
          },
          setcenter(map){
            var moveLatLon = new kakao.maps.LatLng(this.latitude, this.longitude);
            map.setCenter(moveLatLon);
            var marker = new kakao.maps.Marker({ position: map.getCenter() });
          marker.setMap(map);
          },
            
            
            // onLoad (map){
            //   this.map = map
            // },
            // handleGeoSucces(position){
            //   console.log("김용용");
            //   this.latitude = position.coords.latitude;
            //   this.longitude = position.coords.longitude;
            //   console.log(this.latitude + " " + this.longitude);
            // },
            // handleGeoError(){
            //   console.log("error1");
            // }  //카카오 맵 - version 0.1 -
        },
        mounted() {
          navigator
                .geolocation
                .getCurrentPosition(this.handleGeoSucces, this.handleGeoError)
            const script = document.createElement('script');/* global kakao */
            console.log("요기는 오때?")
            script.onload = () => 
                kakao
                .maps
                .load(this.initMap);
            setTimeout(this.initMap, 1700);
            console.log("요기는2 어때2?");
            script.src = 'http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=9ae8801c00947daec17da2217ee254a7';
            document
                .head
                .appendChild(script);
            console.log("김김김김이왔어요");
        },
        
          computed: {
            ...mapState("app", ["collapse"]),
            inputValue: {
                get() {
                    return this.collapse;
                },
                set(val) {
                    this.setDrawer(val);
                }
            },
            
        }
    };
</script>

<style>

#parent{
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  }

</style>