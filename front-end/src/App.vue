<template>
  <div v-if="enter" @click="enterf">
    <Slick />
  </div>
  <div v-else id="app">
    <!-- <Toolbar/> -->
    <!-- <Drawer/> -->
    
    <!-- <div v-if = "width<600">
      <div class="side_bar h4 ml-4 mt-2" v-on:click="openNav()">
        <span class="openmenu" v-on:click="openNav()"><b-icon icon="grid-fill" class="est"></b-icon></span>
      </div>
      <div id="mysidenav" class="sidenav">
        <a href="#" class="closebtn" v-on:click="closeNav()">x</a>
        <router-link to="/">Home</router-link>
        <router-link to="/Weather">Weather</router-link> -->
        <!-- <router-link to="/Aircon">Airconditioner</router-link>
        <router-link to="/Blind">Blind</router-link>
        <router-link to="/Myhome">Myhome</router-link> -->
        <!-- <span v-if = "idid === ''">
              <router-link to="/login">Login</router-link>
              <router-link to="/signup">Signup</router-link>
            </span>
            <span  v-else>
              <div class="side">{{idid}}</div>
              <div class="side" to="/" v-on:click="logout()">Logout</div>
            </span>
      </div>
    </div> -->
    <nav class="main-navigation">
        <div class="navbar-header animated fadeInUp">
            <!-- <a class="navbar-brand" href="#">Smart Home</a> -->
            <img src="./img/logo2.png">
        </div>
        <ul class="nav-list">
            <li class="nav-list-item nav">
                <router-link to="/" class="nav_list">Home</router-link>
            </li>
            <!-- <li class="nav-list-item nav">
                <router-link to="/" class="nav_list">Control</router-link>
            </li> -->
            <!-- <li class="nav-list-item">
                <a href="/login" class="nav-link">login</a>
            </li>
            <li class="nav-list-item">
                <a href="/signup" class="nav-link">Signup</a>
            </li> -->
            <li class="nav-list-item nav" v-if = "idid === ''">
              <router-link to="/login" class="nav_list">Login</router-link>
            </li>
            <li class="nav-list-item nav" v-if = "idid === ''">
              <router-link to="/signup" class="nav_list">Signup</router-link>
            </li>
            <span v-else>
            <li class="nav-list-item nav">
              <div class="side nav_list" style="color:#00419c">{{idid}}</div>
            </li>
            <li class="nav-list-item nav">
              <div class="side nav_list" to="/" v-on:click="logout()">Logout</div>
            </li>
            </span>
        </ul>
    </nav>
    <!-- <div id="Drawer-position"> -->
    <router-view/>
    <!-- </div> -->
    <!-- <div class="footer" id="Footer-position">
  <Footer/>
    </div> -->
    <div class="bottom section-padding">
			<div class="container">
				<div class="row">
					<div class="col-md-12 text-center">
						<div class="copyright">
							<p>© <span>2020</span>  Smart Home Project</p>
						</div>
					</div>
				</div>
			</div>
		</div>
  </div>
</template>

<script>
// import Toolbar from "@/components/Toolbar";
// import Drawer from "@/components/Drawer";
// import Footer from "@/components/Footer";
import Slick from "@/components/Slick";
export default {
  data () {
    return {
      idid:localStorage.getItem("id"),
      width:0,
      height:0,
      check_nav:false,
      enter: true,
    }
  },
  components: {
    // eslint-disable-next-line vue/no-unused-components
    Slick,
    // Footer,
    // Toolbar,
    // Drawer,
  },
  methods:{
    logout(){
      localStorage.setItem("id",'')
      window.location.reload(true)
    },
    handleResize(event){
        this.width = event.currentTarget.visualViewport.width
        this.height = event.currentTarget.visualViewport.height
    },
    openNav(){
      document.getElementById('mysidenav').style.width = '134px';
      // document.getElementById('Footer-position').style.zIndex = '0';
      document.getElementById('Drawer-position').style.zIndex = '0';
    },
    closeNav() {
      if(this.width<600)
			document.getElementById('mysidenav').style.width = '0';
    },
    enterf() {
      this.enter=false;
      sessionStorage.setItem("enter",false)
    },

  },
  mounted(){
    window.addEventListener("resize", this.handleResize)
    this.width = window.innerWidth
    this.height = window.innerHeight
    if(sessionStorage.getItem("enter")){
      this.enter = false;
    }
  }
}
</script>

<style lang="scss">
.nav_list{
    color:black;
    font-size:30px;
}

#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  // font-family: 'Jua', sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  /* color: #2c3e50; */
  /* margin-top: 60px; */
}
.nav{
  text-align: center;
}

a.navbar-brand {
    float: left;
    height: 50px;
    padding: 15px 15px;
    font-size: 18px;
    line-height: 20px;
    text-decoration: none;
    color: orangered;
    font-family: cursive;
    font-weight: 700;

}

nav.main-navigation {
    position: relative;
}

nav.main-navigation ul.nav-list {
    margin: 0;
    padding: 0;
    list-style: none;
    position: relative;
    text-align: center;
}

.nav-list li.nav-list-item {
    display: inline-block;
    line-height: 40px;
    margin-left: 30px;
    /* margin-top: 15px; */
}

a.nav-link {
    text-decoration: none;
    font-size: 18px;
    font-family: sans-serif;
    font-weight: 500;
    cursor: pointer;
    position: relative;
    color: #404040;
}
.nav{
    color: black;
}

@keyframes FadeIn {
    0% {
        opacity: 0;
        -webkit-transition-duration: 0.8s;
        transition-duration: 0.8s;
        -webkit-transform: translateY(-10px);
        -ms-transform: translateY(-10px);
        transform: translateY(-10px);
    }


    100% {
        opacity: 1;
        -webkit-transform: translateY(0);
        -ms-transform: translateY(0);
        transform: translateY(0);
        pointer-events: auto;
        transition: cubic-bezier(0.4, 0, 0.2, 1);
    }
}

.nav-list li {
    animation: FadeIn 1s cubic-bezier(0.65, 0.05, 0.36, 1);
    animation-fill-mode: both;
}

.nav-list li:nth-child(1) {
    animation-delay: .3s;
}

.nav-list li:nth-child(2) {
    animation-delay: .6s;
}

.nav-list li:nth-child(3) {
    animation-delay: .9s;
}

.nav-list li:nth-child(4) {
    animation-delay: 1.2s;
}

.nav-list li:nth-child(5) {
    animation-delay: 1.5s;
}

/* Animation */

@keyframes fadeInUp {
    from {
        transform: translate3d(0, 40px, 0)
    }

    to {
        transform: translate3d(0, 0, 0);
        opacity: 1
    }
}

@-webkit-keyframes fadeInUp {
    from {
        transform: translate3d(0, 40px, 0)
    }

    to {
        transform: translate3d(0, 0, 0);
        opacity: 1
    }
}

.animated {
    animation-duration: 1s;
    animation-fill-mode: both;
    -webkit-animation-duration: 1s;
    -webkit-animation-fill-mode: both
}

.animatedFadeInUp {
    opacity: 0
}

.fadeInUp {
    opacity: 0;
    animation-name: fadeInUp;
    -webkit-animation-name: fadeInUp;
}

.est{
  color: #000;
}

.logout{
  font-weight: bold;
    color: #2c3e50;
    cursor:pointer;
}
.login_info{
  position: absolute;
  right: 10%;
}
#nav {
  padding: 30px;
  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}
#foot{
  text-align: center;
  color:black;
}
html, body{
  height: 100%;
}


a:hover{
    text-decoration:none;
}
.section-padding {
	padding: 15px 0;
}
.bottom {
    background-color: #0a1c2e;
}
.bottom .copyright {
    color: #e5e5e5;
    font-weight: 600;
}
.copyright a {
    color: #f2ff49;
    margin-left: 3px;
    padding-right: 3px;
}
.bottom p {
    margin-bottom: 0;
    line-height: 50px;
    font-size: 16px;
    font-weight: 400;
}
.copyright p span {
    color: #d1caca;
}
.bottom .copyright p, .bottom .copyright a:hover{
    color: #6c6d83;
}
</style>