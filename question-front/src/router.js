import Vue from "vue";
import VueRouter from "vue-router";
import Home from "@/views/Home";

Vue.use(VueRouter);

export const router = new VueRouter({
    mode: 'history',
    routes: [
        {path: '/', component: Home},
        {path: '/auth/login', component: () => import("@/views/Login")},
        {path: '/auth/register', component: () => import("@/views/Registration")},
        {path: '/api/persons', component: () => import("@/views/PersonsList")},
        {path: '/main', component: () => import("@/views/MainPage")},
        {path: '/create', component: () => import("@/views/CreateQuestionare")},
        {path: '/show', component: () => import("@/views/ShowQuestionare")},
    ]
})

router.beforeEach((to, from, next) => {
    const publicPages = ['/auth/login', '/auth/register', '/'];
    const authRequired = !publicPages.includes(to.path);
    const loggedIn = localStorage.getItem('user');

    if (authRequired && !loggedIn) {
        return next('/auth/login');
    }

    next();
})