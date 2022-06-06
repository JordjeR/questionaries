import axios from "axios";

const API_PERSONS = 'http://localhost:8080';
// const GET_USER = 'http://localhost:8080/auth/login';

import {AXIOS} from "@/http-commons";
import authHeader from "@/auth-header";
import PersonsService from "@/services/PersonsService";

export default {
    actions: {
        async fetchPerson(ctx) {
            const persons = await axios.get(API_PERSONS + "/api/persons", {
                headers: authHeader()
            }).then(persons => persons.data).catch(err => {
                console.log("Произошла ошибка загрузки с сервера " + err + "!")
            });

            ctx.commit("updatePersons", persons);
        },
        async addPerson(ctx, person) {
            return PersonsService.addPerson(person)
                .then(person => {
                    ctx.commit("updatePersons", person)
                    return Promise.resolve(person);
                })
                .catch(error => {
                    return Promise.reject(error);
                });
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