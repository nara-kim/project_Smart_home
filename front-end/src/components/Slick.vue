<template>
  <b-container class="prat" fluid>
          <b-row class="justify-content-center" align-v="center">
        <b-card
            overlay
            center
            img-src="https://upload.wikimedia.org/wikipedia/commons/2/29/Phone-icon.svg"
            img-alt="핸드폰"
            style="width:auto; max-width: 25rem; cursor:pointer;"
            @click="enterf"
            >
            <br>
            <br>
            <div class="centered">
            <div class="image_el">
            <VueSlickCarousel class="carouselContainer" v-bind="carouselSettings">
                <img class="img_el" src="../img/pre.png" alt="">
                <img class="img_el" src="../img/pre1.png" alt="">
                <img class="img_el" src="../img/pre2.png" alt="">
                <!-- <img class="img_el" src="../assets/smarthome.jpg" alt=""> -->
            </VueSlickCarousel>
           </div>
            </div>
            </b-card>
          </b-row>
      </b-container>
</template>

<script>
   import VueSlickCarousel from 'vue-slick-carousel'
   import 'vue-slick-carousel/dist/vue-slick-carousel.css'
   import 'vue-slick-carousel/dist/vue-slick-carousel-theme.css'

export default {
  components: {VueSlickCarousel},
  data () {
    return {
      carouselSettings: {
        slidesToShow: 1,
        arrows: false,
        dots: true,
        touchMove: true,
        dotsClass: 'slick-dots',
        autoplay: true,
        autoplaySpeed: 1700,
        },

    }
  }
}
</script>

<style>
.image_el {
    width: 100%;
    /* height: 40%; */
    text-align: center;
    margin:0 auto;
    margin-top: 10px;
    /* border: 1px solid red; */
    overflow: hidden; 
}
.image_el .img_el {
    width: 100%;
    height: auto;
    min-height: 320px;
}
.prat{
  position:absolute;
  top:0;right:0;bottom:0;left:0;
  display:flex;
  align-items:center;
  justify-content:center;
  display:-webkit-flex;
  -webkit-align-item:center;
  -webkit-justify-content:center;
}

</style>