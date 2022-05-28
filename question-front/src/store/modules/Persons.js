const GET_PERSONS = 'http://localhost:8080/persons';

export default {
    actions: {
        async fetchPerson(ctx) {
            const res = await fetch(GET_PERSONS)
                .then(res => res.json())
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