<template>
    <div class="box">
        <div class="container">
            <div class="row" id="test1">
                <div class="col-lg-3 col-6" id="border-check">
                    <div class="box-part text-center">
                        <img src="../img/light2.png" style="width:50%">
                        <div class="title">
                            <!-- <h5>전등</h5> -->
                        </div>
                        <div style="float:left; width:50%">
                        <div class="toggle" v-on:click="led" style="margin-left:28%; margin-top:15px;">
                            <input type="checkbox" class="toggle-checkbox" id="disabled6" >
                            <label class="toggle-label" for="disabled6">
                                <span class="toggle-inner"></span>
                                <span class="toggle-switch"></span>
                            </label>
                        </div>
                        </div>
                        <div style="float:right; width:50%">
                            <img src="../img/setting.png" style="width:30%; margin-top:15px;" @click="$bvModal.show('bv-modal-example1')">

                            <b-modal id="bv-modal-example1" hide-footer>
                                <template v-slot:modal-title>
                                조명 색
                                </template>
                                <div class="d-block text-center">
                                    <div class="container-fluid margin">
                                        <a v-on:click="r" class="b_r" style="width:50%">빨간색</a>
                                    </div>
                                    <div class="container-fluid margin">
                                        <a v-on:click="b" class="b_g" style="width:50%">초록색</a>
                                    </div>
                                    <div class="container-fluid margin">
                                        <a  v-on:click="g" class="b_b" style="width:50%">파란색</a>
                                    </div>
                                </div>
                                <b-button class="mt-3" block @click="$bvModal.hide('bv-modal-example1')">확인</b-button>
                            </b-modal>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-6" id="border-check">
                    <div class="box-part text-center">
                        <img src="../img/aircon2.png" style="width:70%">
                        <div class="title">
                            <!-- <h5>에어컨</h5> -->
                        </div>
                        <div class="toggle" v-on:click="aircon" style="margin-left:28%; margin-top:15px;">
                            <input type="checkbox" class="toggle-checkbox" id="disabled" >
                            <label class="toggle-label" for="disabled">
                                <span class="toggle-inner"></span>
                                <span class="toggle-switch"></span>
                            </label>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-6" id="border-check">
                    <div class="box-part text-center">
                        <img src="../img/blind1.png" style="width:50%">
                        <div class="title">
                            <!-- <h5>블라인드</h5> -->
                        </div>
                        <div class="toggle" v-on:click="blind" style="margin-left:28%; margin-top:15px;">
                            <input type="checkbox" class="toggle-checkbox" id="disabled1">
                            <label class="toggle-label" for="disabled1">
                                <span class="toggle-inner"></span>
                                <span class="toggle-switch"></span>
                            </label>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-6" id="border-check">
                    <div class="box-part text-center">
                        <img src="../img/rutin.png" style="width:50%">
                        <div class="title">
                            <!-- <h5>알람</h5> -->
                        </div>
                        <div style="float:left; width:50%">
                            <div class="toggle" v-on:click="ru" style="margin-left:28%; margin-top:15px;">
                                <input type="checkbox" class="toggle-checkbox" id="disabled3">
                                <label class="toggle-label" for="disabled3">
                                    <span class="toggle-inner"></span>
                                    <span class="toggle-switch"></span>
                                </label>
                            </div>
                        </div>
                        <div style="float:right; width:50%">
                            <img src="../img/setting.png" style="width:30%; margin-top:15px;" @click="$bvModal.show('bv-modal-example')">

                            <b-modal id="bv-modal-example" hide-footer>
                                <template v-slot:modal-title>
                                동시 실행 할 디바이스를 선택하세요.
                                </template>
                                <div class="d-block text-center">
                                    <div class="container-fluid margin">
                                        <a v-on:click="ru_air" class="themeBtn2" style="width:50%">에어컨</a>
                                    </div>
                                    <div class="container-fluid margin">
                                        <a v-on:click="ru_bl" class="themeBtn2" style="width:50%">블라인드</a>
                                    </div>
                                    <div class="container-fluid margin">
                                        <a  v-on:click="ru_led" class="themeBtn2" style="width:50%">조명</a>
                                    </div>
                                    <div class="container-fluid margin">
                                        <a  v-on:click="ru_reset" class="themeBtn2" style="width:50%">초기화</a>
                                    </div>
                                </div>
                                <hr>
                                <!-- <div v-for="item in rutine" v-bind:key = "item">{{ item }}</div> -->
                                <div class="container-fluid margin">
                                    <div class="themeBtn3" v-for="item in rutine" v-bind:key = "item">{{item}}</div>
                                </div>
                                <b-button class="mt-3" block @click="$bvModal.hide('bv-modal-example')">확인</b-button>
                            </b-modal>
                        </div>
                        <!-- <div>
                            <b-button variant="primary" v-on:click="ru_led">전등</b-button>
                            <b-button variant="primary" v-on:click="ru_air">에어컨</b-button>
                            <b-button variant="primary" v-on:click="ru_bl">블라인드</b-button>
                            <b-button variant="primary" v-on:click="ru_reset">루틴 초기화</b-button>
                        </div> -->
                    </div>
                </div>

            </div>
        </div>
    </div>
</template>

<script>
import address from '../http_ad'
export default {
  data () {
      return{
        rutine:[]
      }
  },
  methods: {
    aircon: function () {
      address.get('/post/air')
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
        console.log(this.rutine.length)
        for(var i = 0;i<this.rutine.length;i++){
            console.log("?? "+this.rutine[i])
            if(this.rutine[i]==='에어컨'){
                this.aircon()
            }else if(this.rutine[i]==='블라인드'){
                this.blind()
            }else{
                this.led()
            }
        }
    },
    ru_air :function(){
        this.rutine.push("에어컨")
        console.log(this.rutine)
    },
    ru_led :function(){
        this.rutine.push("조명")
        console.log(this.rutine)
    },
     ru_bl :function(){
        this.rutine.push("블라인드")
    },
    ru_reset: function(){
        this.rutine = [];
    }
  }
}
</script>

<style scoped>
#border-check{
  border: 1px groove;
  
}
#test1{
  background-color: #d7eafd;
}
body{
    background: #eee;
}
span{
    font-size:15px;
}
a{
  text-decoration:none; 
  color: #0062cc;
  border-bottom:2px solid #0062cc;
}
.box-part{
    border-radius:0;
    margin:30px 0px;
    margin-left: 3px;
}
.text{
    margin:15px 0px;
}
.fa{
     color:#4183D7;
}

.toggle {
	position: relative; 
	width: 65px;
	-webkit-user-select:none; 
	-moz-user-select:none; 
	-ms-user-select: none;
}
.toggle-checkbox {
	display: none;
}
.toggle-label {
	display: block; 
	overflow: hidden; 
	cursor: pointer;
	border-radius: 30px;
	border: 2px solid #FFF; 
}
.toggle-inner {
	display: block; 
	width: 200%; 
	margin-left: -100%;
	transition: margin 0.3s ease-in 0s;
}
.toggle-inner:before,
.toggle-inner:after {
	display: block; 
	float: left; 
	width: 50%; 
	height: 20px; 
	padding: 0; 
	line-height: 20px;
	font-size: 12px; 
	color: white;
	font-family: Trebuchet, Arial, sans-serif; 
	font-weight: bold;
	box-sizing: border-box;
}
.toggle-inner:before {
	content: "ON";
	/* padding-left: 15px; */
	background-color: #007BFF;
}
.toggle-inner:after {
	content: "OFF";
	padding-right: 14px;
	background-color: #999999; color: #333333;
	text-align: right;
}
/*Bolita*/
.toggle-switch {
	display: block; 
	width: 18px; 
	margin: 4px;
	background: #FFFFFF;
	position: absolute; 
	top: 0; 
	bottom: 0;
	right: 39px;
	border: 2px solid #FFFFFF; 
	border-radius: 30px;
	transition: all 0.3s ease-in 0s; 
}
.toggle-checkbox:checked + .toggle-label .toggle-inner {
	margin-left: 0;
}
.toggle-checkbox:checked + .toggle-label .toggle-switch {
	right: 0px; 
}

.margin{
    margin-top:20px;    
    margin-bottom:20px;
}

.b_r {
    background: #f61d1d;
    color: #ffffff !important;
    display: inline-block;
    font-size: 15px;
    font-weight: 500;
    height: 50px;
    line-height: 0.8;
    padding: 18px 30px;
    text-transform: capitalize;
    border-radius: 1px;
    letter-spacing: 0.5px;
	border:0px !important;
	cursor:pointer;
	border-radius:100px;

}
.b_g {
    background: #3db800f0;
    color: #ffffff !important;
    display: inline-block;
    font-size: 15px;
    font-weight: 500;
    height: 50px;
    line-height: 0.8;
    padding: 18px 30px;
    text-transform: capitalize;
    border-radius: 1px;
    letter-spacing: 0.5px;
	border:0px !important;
	cursor:pointer;
	border-radius:100px;

}
.b_b {
    background: #2f2fdf;
    color: #ffffff !important;
    display: inline-block;
    font-size: 15px;
    font-weight: 500;
    height: 50px;
    line-height: 0.8;
    padding: 18px 30px;
    text-transform: capitalize;
    border-radius: 1px;
    letter-spacing: 0.5px;
	border:0px !important;
	cursor:pointer;
	border-radius:100px;

}

.themeBtn2 {
    background: #7600ff;
    color: #ffffff !important;
    display: inline-block;
    font-size: 15px;
    font-weight: 500;
    height: 50px;
    line-height: 0.8;
    padding: 18px 30px;
    text-transform: capitalize;
    border-radius: 1px;
    letter-spacing: 0.5px;
	border:0px !important;
	cursor:pointer;
	border-radius:100px;

}
.themeBtn2:hover {
    background: rgb(118, 0, 255);
    color: #ffffff;
    box-shadow: 0 10px 25px -2px rgba(118, 0, 255, 0.6);
}
.themeBtn3 {
    background: #ff2e4d;
    color: #ffffff !important;
    display: inline-block;
    font-size: 15px;
    font-weight: 500;
    height: 50px;
    line-height: 0.8;
    padding: 18px 30px;
    text-transform: capitalize;
    border-radius: 1px;
    letter-spacing: 0.5px;
	border:0px !important;
	cursor:pointer;
	border-radius:100px;

}
.themeBtn3:hover {
    background: rgb(255, 46, 77);
    color: #ffffff;
    box-shadow: 0 10px 25px -2px rgba(255, 46, 77, 0.6);
}
.themeBtn4 {
    background: #006eff;
    color: #ffffff !important;
    display: inline-block;
    font-size: 15px;
    font-weight: 500;
    height: 50px;
    line-height: 0.8;
    padding: 18px 30px;
    text-transform: capitalize;
    border-radius: 1px;
    letter-spacing: 0.5px;
	border:0px !important;
	cursor:pointer;
	border-radius:100px;

}
.themeBtn4:hover {
    background: rgb(0, 110, 255);
    color: #ffffff;
    box-shadow: 0 10px 25px -2px rgba(0, 110, 255, 0.6);
}

</style>
