import Vue from "vue";
import Vuex from "vuex";
import person from "./modules/PersonsModule";
import authMod from "./modules/AuthModule"

Vue.use(Vuex)

export default new Vuex.Store({
    modules: {
        person,
        authMod
    }
});