<template>
    <div class="container">
        <hr class="hr-warning"/>
        <div class="row" id="parent">
            <div id="child">
                <b-button @click="home" class="btn btn-light" id="home-button">
                    <b-icon icon="house-fill" class="ml-2"></b-icon>
                    <p>&copy; 2020</p>
                </b-button>
            </div>
        </div>
    </div>
</template>
<script>
export default {
  data: () => {

  },
  methods: {
    home () {
      this.$router.push("/");
    }
  }  
}
</script>



<style>

#home-button{
  background-color: white;
  border: 0px;
  outline: 0px;
  visibility: visible;
}
#parent{
  position: relative;
  margin-top: 1px;
}
#child{
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  margin-left: 10px;
}
.hr-warning{
  background-image: -webkit-linear-gradient(left, rgba(210,105,30,.8), rgba(210,105,30,.6), rgba(0,0,0,0));
  margin-top: 2rem;
}

</style>