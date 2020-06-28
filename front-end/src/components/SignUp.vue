<template>
   <div>
    <!-- <b-form inline>
      <div>
      <label class="sr-only" for="inlineFormInputName2">Name</label>
      <b-input class="mb-2 mr-sm-2 mb-sm-0" id="inlineFormInputName2" v-model="episodes"  />
      <b-button variant="primary" v-on:click="login">콘솔 확인</b-button>
      <b-input class="mb-2 mr-sm-2 mb-sm-0" id="inlineFormInputName2" v-model="result"  />
      </div>
    </b-form>
          <br>
    <b-form inline>
      <div>
      <b-input class="mb-2 mr-sm-2 mb-sm-0" id="inlineFormInputName2" v-model="x"  />
      <b-button variant="primary" v-on:click="post">콘솔 확인</b-button>
      <b-input class="mb-2 mr-sm-2 mb-sm-0" id="inlineFormInputName2" v-model="y"  />
      </div>
    </b-form> -->

      <!-- <b-input class="mb-2 mr-sm-2 mb-sm-0" id="inlineFormInputName2" v-model="x"  />
      <b-button variant="primary" v-on:click="post">123123123인</b-button>

      <input type="text" class="mb-sm-2" id="email" name="pid" placeholder="Enter id" value="" v-model="user.id"><br>
			<input type="password" class="mb-sm-2" placeholder="Enter password" value=""  v-model="user.pw"><br>
			<input type="password" class="mb-sm-2" placeholder="Enter password" value=""  v-model="user.pw_check"><br>
			<input type="text" class="mb-sm-2" maxlength="20" placeholder="Enter name" value="" v-model="user.name"><br>
    
    <b-button variant="primary" v-on:click="signUp">회원가입</b-button>
  </div> -->
  <div class="main">
    <h1>Sign Up</h1>
    <!-- <div class="d-flex justify-content-center">
		</div> -->
      <fieldset>
        <div class='kickass_field'>
          <input type="text" name="pid" value="" v-model="user.name" maxlength='30' required='required'>
          <lable>
            Username
            <span>Your chosen username</span>
          </lable>
        </div>
        <div class='kickass_field'>
          <input type="text" value="" v-model="user.id" maxlength='30' required='required'>
          <lable>
            ID
            <span>Your chosen username</span>
          </lable>
        </div>
        <div class='kickass_field'>
          <input value="" v-model="user.email" maxlength='30' required='required' type='email'>
          <lable>
            Email address
            <span>Your current email address</span>
          </lable>
        </div>
        <div class='kickass_field'>
          <input value="" v-model="user.pw" maxlength='30' pattern='.{6,}' required='required' type='password'>
          <lable>
            Password
            <span>Minimum of 6 characters</span>
          </lable>
        </div>
        <button variant="primary" v-on:click="signUp()">Sign up</button>
      </fieldset>
</div>

   </div>
</template>
<script>
import common from '../http_common'
// import axios from 'axios'
export default {
  name: 'Sin',
  data () {
    return {
      episodes: '',
      result: '',
      x: '',
      y: '',
      user: {
        id: '',
        pw: '',
        pw_check: '',
        name: '',
        email: ''
      },
      error_msg: '',
      nameRules : [v => !! v || "아이디는 필수입니다"],
    }
  },
    
  methods: {
    post: function () {
      common.get('/post/' + this.x)
        .then((res) => {
          this.y = res.data
        })
    },
    login: function () {
      common.get('/click')
        .then((res) => {
          this.result = res.data
        })
        .catch((error) => {
          // eslint-disable-next-line
          console.error(error);
        })
    },
    getEps () {
      common.get('/welcome2')
        .then((res) => (this.episodes = res.data))
        .catch((error) => {
          // eslint-disable-next-line
          console.error(error);
        })
    },
    signUp: function(){
      common.post('/SignUp', this.user)
      this.$router.push("/login")
    },
    loginpage() {
      this.$router.push("/login")
    }
  },
  created () {
    this.getEps()
  }
}
</script>

<style scoped>
@import url(http://fonts.googleapis.com/css?family=Lato:300,400,700);
body {
  font-family: "Lato", sans-serif;
  text-align: center;
  height: 100vh;
  overflow: hidden;
  margin: 0;
  /* --- Form styling --- */
}
body fieldset {
  border: none;
}
body fieldset:valid > button {
  opacity: 1;
}
body fieldset:valid > button:hover {
  opacity: 1;
  background: #6eb3f3;
}
body button {
  width: 150px;
  height: 50px;
  opacity: .5;
  text-align: center;
  cursor: pointer;
  -webkit-transition: all .4s;
  transition: all .4s;
  border: none;
  font-family: "Lato", sans-serif;
  padding: 0px;
  background-color: #6eb3f3;
  color: white;
  outline: none;
  margin-top: 13px;
}
body .kickass_field {
  margin: auto;
  position: relative;
  left: 0;
  top: 0;
  bottom: 0;
  height: 80px;
  right: 0;
  width: 280px;
}
body .kickass_field lable {
  font-size: 14px;
  position: absolute;
  height: 100px;
  overflow: hidden;
  left: 0;
  width: 100%;
  top: 50px;
  text-align: left;
  font-weight: 700;
  font-family: "Lato", sans-serif;
  pointer-events: none;
  -webkit-transition: all .2s .3s;
  transition: all .2s .3s;
  margin-left: 26px;
  margin-top: 5px;
}
body .kickass_field lable span {
  font-size: 10px;
  color: #9f9fb5;
  clear: left;
  opacity: 0;
  font-weight: 400;
  display: block;
  -webkit-transition: opacity .5s .0s;
  transition: opacity .5s .0s;
  margin-left: 2px;
}
/* body .kickass_field lable:after {
  width: 4px;
  content: '';
  height: 8px;
  border-bottom: 2px solid #f65252;
  border-right: 2px solid #f65252;
  -webkit-transform: translateX(-40px) rotate(45deg);
          transform: translateX(-40px) rotate(45deg);
  position: absolute;
  left: 120%;
  top: 25px;
  -webkit-transition: all .2s;
  transition: all .2s;
} */
body .kickass_field input {
  border: none;
  color: #6E738A;
  font-weight: 400;
  padding: 40px 0px 10px 0px;
  background: transparent;
  letter-spacing: 1px;
  outline: none;
  font-family: "Lato", sans-serif;
  height: 30px;
  width: 220px;
  -webkit-transition-property: -webkit-transform;
  transition-property: -webkit-transform;
  transition-property: transform;
  transition-property: transform, -webkit-transform;
  font-size: 14px;
  box-shadow: 0px 2px grey;
}
body .kickass_field input:focus + lable {
  color: #6eb3f3;
  font-size: 10px;
  top: -4px;
  -webkit-transition: all .2s .0s;
  transition: all .2s .0s;
  
}
body .kickass_field input:focus + lable span {
  opacity: 1;
  -webkit-transition: opacity .5s .3s;
  transition: opacity .5s .3s;
}
body .kickass_field input:valid + lable {
  font-size: 10px;
  top:-4px;
  color: grey;
}
body .kickass_field input[type="password"]:valid + lable span {
  color: #99B62F;
}
body .kickass_field input:valid + lable span {
  opacity: 1;
  -webkit-transition: opacity .3s 0s;
  transition: opacity .3s 0s;
}
body .kickass_field input:valid + lable::after {
  display: block;
  left: 100%;
}
body .kickass_field input:invalid {
  color: #f9f9f9;
}
body .kickass_field input:focus:invalid {
  color: #6E738A;
}

/* --- End Form styling --- */
/* --- Begin template styling --- */
.main {
  background: #f9f9f9;
  border: 14px solid #f9f9f9;
  height: 100%;
  width: 100%;
  padding: 40px;
  box-sizing: border-box;
  /* --- End template styling --- */
}
.container_inner {
  position: absolute;
  left: 0;
  right: 0;
  top: 50%;
  -webkit-transform: translateY(-50%);
          transform: translateY(-50%);
}
.container h1, .container h2 {
  font-weight: 300;
}
.container h1 {
  margin: 0;
  color: #6E738A;
}
.container p {
  color: #6E738A;
  font-weight: 300;
  margin-top: 40px;
}
.container .love span {
  font-size: 12px;
  color: #bcbcbc;
  font-weight: 300;
}
.container .love span a {
  color: #f65252;
  font-weight: 700;
}
.container .love span img {
  position: relative;
  margin: 3px;
  top: 7px;
}
.container h2 {
  margin: 7px 0 24px 0;
  font-size: 22px;
  color: #9A9FB5;
}
.container a {
  color: #f65252;
  text-decoration: none;
}
.container a:hover {
  text-decoration: underline;
}
.brand_logo_container {
  position: absolute;
  height: 85px;
  width: 85px;
  top: 60px;
  border-radius: 50%;
  background: #60a3bc;
  padding: 10px;
  text-align: center;
}
.brand_logo {
  height: 65px;
  width: 65px;
  border-radius: 50%;
  border: 2px solid white;
}
</style>
