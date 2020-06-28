import { set, toggle } from "@/utils/vuex";

const state = {
  collapse: null
  
};

// mutations
const mutations = {
  setDrawer: set("collapse"),
  toggleDrawer: toggle("collapse")
};

export default {
  namespaced: true,
  state,
  mutations
};
