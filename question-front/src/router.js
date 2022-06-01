import Vue from "vue";
import VueRouter from "vue-router";
import Home from "@/views/Home";

Vue.use(VueRouter);

export default new VueRouter({
    mode: 'history',
    routes: [
        {
            path: '/',
            component: Home
        },
        {
            path: '/auth',
            component: () => import("@/views/Login")
        },
        {
            path: '/api/persons',
            component: () => import("@/views/PersonsList")
        },
        {
            path: '/auth/register',
            component: () => import("@/views/Registration")
        },
    ]
})
