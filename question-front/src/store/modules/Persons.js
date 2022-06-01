import axios from "axios";

const GET_PERSONS = 'http://localhost:8080';
// const GET_USER = 'http://localhost:8080/auth/login';

import { AXIOS } from "@/http-commons";
import authHeader from "@/auth-header";

export default {
    actions: {
        async fetchPerson(ctx) {
            const res = await axios.get(GET_PERSONS + '/api/persons', {
                headers: authHeader()
            })
                .then(res => res.data)
                .catch(err => console.log("Произошла ошибка загрузки с сервера " + err + "!"));

            ctx.commit('updatePersons', res);
        }
    },
    mutations: {
        updatePersons(state, persons) {
            state.persons = persons;
        }
    },
    state: {
        persons: [],
    },
    getters: {
        allPersons(state) {
            return state.persons;
        }
    }
}