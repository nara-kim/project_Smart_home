<template>
    <b-navbar
        toggleable="toggleable"
        id="app-toolbar"
        variant="white"
        class="contest mt-0"
        >  <!--배경색 -->
        <b-button size="sm" id="test2" class="btn btn-light">
            <!-- <div class="h4">   <-- 버튼 영역 
            <b-icon icon="grid-fill"></b-icon>
            </div> -->
        </b-button>
       <b-navbar-nav class="navbar abs ml-1" href="#">
         <img v-bind="main" src="../assets/smarthome.jpg" alt="smarthomelogo">
       </b-navbar-nav>
        <b-navbar-toggle target="collapse" id="test1">
        <b-button v-if="responsive" @click="onClickDrawer1" id="test1" class="btn btn-light">
            <div class="h4">
            <b-icon icon="geo-alt"></b-icon>
            </div>
        </b-button>
        </b-navbar-toggle>
    
    </b-navbar>
</template>

<script>
import { mapMutations, mapState } from "vuex";

export default {
  data: () => ({
    responsive: false,
    main: {
      width: 95,
      height: 55,
      center: true,
    }
  }),
  computed: {
    ...mapState("app", ["collapse"])
  },
  mounted() {
    this.onResponsiveInverted();
    window.addEventListener("resize", this.onResponsiveInverted);
  },
  beforeDestroy() {
    window.removeEventListener("resize", this.onResponsiveInverted);
  },

  methods: {
    ...mapMutations("app", ["setDrawer"]),
    
    onClickDrawer1() {
      this.setDrawer(!this.collapse);
      console.log("김찬영");
    },
    onResponsiveInverted() {
      if (window.innerWidth < 900) {
        this.responsive = true;
      } else {
        this.responsive = false;
      }
    }
  }
};
</script>


<style>
#app-toolbar{
  padding-bottom: 0px;
}
#test1{
  background-color: white;
  outline: 0;
  border: 0;
  position: relative;
  z-index: 1;
}
#test2{
  z-index: 0;
  visibility: hidden;
}
.navbar.abs
    {
        position: absolute;
        z-index: 0;
        width: 100%;
        left: 0;
        text-align: center;
    }




</style>