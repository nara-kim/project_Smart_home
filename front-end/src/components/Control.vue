<template>
    <div class="box">
        <div class="container">
            <div class="row" id="test1">
                <!-- 전등 -->
                <div class="col-lg-3 col-6" id="border-check">
                    <div class="box-part text-center">
                        <img src="../img/light2.png" style="width:50%">
                        <div class="title">
                        </div>
                        <div style="float:left; width:50%">
                        <!-- 토글버튼을 클릭하면 led 함수를 실행 -->
                        <div class="toggle" v-on:click="led" style="margin-left:28%; margin-top:15px;">
                            <input type="checkbox" class="toggle-checkbox" id="disabled6" >
                            <label class="toggle-label" for="disabled6">
                                <span class="toggle-inner"></span>
                                <span class="toggle-switch"></span>
                            </label>
                        </div>
                        </div>
                        <div style="float:right; width:50%">
                            <!-- 클릭하면 모달창 열림  -->
                            <img src="../img/setting.png" style="width:30%; margin-top:15px;" @click="$bvModal.show('bv-modal-example1')">

                            <!-- 모달창 -->
                            <b-modal id="bv-modal-example1" hide-footer>
                                <template v-slot:modal-title>
                                조명 색
                                </template>
                                <div class="d-block text-center">
                                    <div class="container-fluid margin">
                                        <!-- 버튼 클릭시 r함수 실행 -->
                                        <a v-on:click="r" class="b_r" style="width:50%">빨간색</a>
                                    </div>
                                    <div class="container-fluid margin">
                                        <!-- 버튼 클릭시 b함수 실행 -->
                                        <a v-on:click="b" class="b_g" style="width:50%">초록색</a>
                                    </div>
                                    <div class="container-fluid margin">
                                        <!-- 버튼 클릭시 g함수 실행 -->
                                        <a  v-on:click="g" class="b_b" style="width:50%">파란색</a>
                                    </div>
                                </div>
                                <!-- 확인 버튼을 누르면 모달창이 닫힘 -->
                                <b-button class="mt-3" block @click="$bvModal.hide('bv-modal-example1')">확인</b-button>
                            </b-modal>
                        </div>
                    </div>
                </div>
                <!-- 에어컨 -->
                <div class="col-lg-3 col-6" id="border-check">
                    <div class="box-part text-center">
                        <img src="../img/aircon2.png" style="width:70%">
                        <div class="title">
                        </div>
                        <!-- 토글버튼을 클릭하면 aircon 함수를 실행 -->
                        <div class="toggle" v-on:click="aircon" style="margin-left:28%; margin-top:15px;">
                            <input type="checkbox" class="toggle-checkbox" id="disabled" >
                            <label class="toggle-label" for="disabled">
                                <span class="toggle-inner"></span>
                                <span class="toggle-switch"></span>
                            </label>
                        </div>
                    </div>
                </div>
                <!-- 블라인드 -->
                <div class="col-lg-3 col-6" id="border-check">
                    <div class="box-part text-center">
                        <img src="../img/blind1.png" style="width:50%">
                        <div class="title">
                        </div>
                        <!-- 토글버튼을 클릭하면 blind 함수를 실행 -->
                        <div class="toggle" v-on:click="blind" style="margin-left:28%; margin-top:15px;">
                            <input type="checkbox" class="toggle-checkbox" id="disabled1">
                            <label class="toggle-label" for="disabled1">
                                <span class="toggle-inner"></span>
                                <span class="toggle-switch"></span>
                            </label>
                        </div>
                    </div>
                </div>
                <!-- 루틴 -->
                <div class="col-lg-3 col-6" id="border-check">
                    <div class="box-part text-center">
                        <img src="../img/rutin.png" style="width:50%">
                        <div class="title">
                        </div>
                        <div style="float:left; width:50%">
                            <!-- 토글버튼을 클릭하면 ru 함수를 실행 -->
                            <div class="toggle" v-on:click="ru" style="margin-left:28%; margin-top:15px;">
                                <input type="checkbox" class="toggle-checkbox" id="disabled3">
                                <label class="toggle-label" for="disabled3">
                                    <span class="toggle-inner"></span>
                                    <span class="toggle-switch"></span>
                                </label>
                            </div>
                        </div>
                        <div style="float:right; width:50%">
                            <!-- 클릭시 모달창 열림 -->
                            <img src="../img/setting.png" style="width:30%; margin-top:15px;" @click="$bvModal.show('bv-modal-example')">

                            <b-modal id="bv-modal-example" hide-footer>
                                <template v-slot:modal-title>
                                동시 실행 할 디바이스를 선택하세요.
                                </template>
                                <div class="d-block text-center">
                                    <div class="container-fluid margin">
                                        <!-- 클릭시 ru_air 함수 실행 -->
                                        <a v-on:click="ru_air" class="themeBtn2" style="width:50%">에어컨</a>
                                    </div>
                                    <div class="container-fluid margin">
                                        <!-- 클릭시 ru_bl 함수 실행 -->
                                        <a v-on:click="ru_bl" class="themeBtn2" style="width:50%">블라인드</a>
                                    </div>
                                    <div class="container-fluid margin">
                                        <!-- 클릭시 ru_led 함수 실행 -->
                                        <a  v-on:click="ru_led" class="themeBtn2" style="width:50%">조명</a>
                                    </div>
                                    <div class="container-fluid margin">
                                        <!-- 클릭시 ru_reset 함수 실행 -->
                                        <a  v-on:click="ru_reset" class="themeBtn2" style="width:50%">초기화</a>
                                    </div>
                                </div>
                                <hr>
                                <div class="container-fluid margin">
                                    <!-- rutine 배열에서 값들을 하나씩 가져옴-->
                                    <div class="themeBtn3" v-for="item in rutine" v-bind:key = "item">{{item}}</div>
                                </div>
                                <!-- 확인버튼 클릭시 모달창 닫힘 -->
                                <b-button class="mt-3" block @click="$bvModal.hide('bv-modal-example')">확인</b-button>
                            </b-modal>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</template>

<script>
//axios를 이용한 http통신(이름을 address로 정함)
import address from '../http_ad'
export default {
  data () { //여기 안에는 내가 사용할 변수를 선언
      return{
        rutine:[]   //rutine 배열을 선언
      }
  },
  methods: {    //함수
    aircon: function () {   //aircon 함수
      address.get('/post/air')  //get으로 서버로부터 '/post/air'주소로 접근하여 아두이노의 동작을 실행
    },
    blind: function () {
      address.get('/post/5')
    },
    r: function () {
        address.get('/post/r')
    },
    g: function () {
      address.get('/post/g')
    },
    b: function () {
      address.get('/post/b')
    },
    led: function () {
      address.get('/post/led')
    },
    ru :function(){
        for(var i = 0;i<this.rutine.length;i++){
            if(this.rutine[i]==='에어컨'){
                this.aircon()   //'에어컨'이면 aircon함수 실행
            }else if(this.rutine[i]==='블라인드'){
                this.blind()
            }else{
                this.led()
            }
        }
    },
    ru_air :function(){
        this.rutine.push("에어컨")  //rutine 배열에 "에어컨"을 넣어줌
    },
    ru_led :function(){
        this.rutine.push("조명")
    },
     ru_bl :function(){
        this.rutine.push("블라인드")
    },
    ru_reset: function(){
        this.rutine = [];   //rutine 배열을 비워줌
    }
  }
}
</script>

<style>
    @import "../assets/style.css";
</style>