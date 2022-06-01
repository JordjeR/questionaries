import Vue from "vue";
import Vuex from "vuex";
import person from "./modules/Persons";
import authMod from "./modules/AuthModule"

Vue.use(Vuex)

export default new Vuex.Store({
    modules: {
        person,
        authMod
    }
});