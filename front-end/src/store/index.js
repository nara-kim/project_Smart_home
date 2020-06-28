import Vue from "vue";
import Vuex from "vuex";

import app from "./modules/app";
import geo from "./modules/geo";

Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    app,
    geo
  }
});
