import axios from "axios";

const API_PERSON = 'http://localhost:8080';

class PersonsService {
    getPersons() {
        return axios.get(API_PERSON);
    }

    addPerson(person) {
        return axios.post(API_PERSON + '/api/persons/add', person);
    }
}

export default new PersonsService();