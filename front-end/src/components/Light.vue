<template>
  <div class="container">
    <div class="row">
        <div class="col-12">
          <!-- <div>
            <h1>Air Conditioner</h1>
            <label class="switch">
            <input type="checkbox" checked>
            <span class="slider round"></span>
            <span class="absolute-no">NO</span>
          </label>
          </div> -->
          <div class="form-group row" data-key="disabled">
            <h1 class="col-8">Air Conditioner</h1>
            <div class="col-4 input" style="margin-top:4%">
              <div class="toggle">
                <input type="checkbox" class="toggle-checkbox" id="disabled">
                <label class="toggle-label" for="disabled">
                  <span class="toggle-inner"></span>
                  <span class="toggle-switch"></span>
                </label>
              </div>
            </div>
        </div>
          <hr>
          <div>
          <img src="../img/aircon.png" style="width:75%">
          </div>
          <hr>
          <h3>현재온도 : 20도</h3>
          <h3>현재습도 : 30%</h3>
        </div>
        
    </div>
  </div>
</template>

<script>
export default {
  
}
</script>

<style>

</style>