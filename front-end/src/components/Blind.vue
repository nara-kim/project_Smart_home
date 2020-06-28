<template>
  <div class="container">
    <div class="row">
        <div class="col-12">
          <div class="form-group row" data-key="disabled">
            <h1 class="col-8">Blind</h1>
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
          <img src="../img/Blind.png" style="width:75%">
          </div>
          <hr>
          <h3>조도,,,,,훔,,</h3>
        </div>
    </div>
  </div>
</template>

<script>
export default {
  
}
</script>


<style scoped>
.hh {
  display: inline;
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
</style>
