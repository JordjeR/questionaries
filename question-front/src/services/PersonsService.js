import axios from "axios";

const PERSON_GET = 'http://localhost:8080/persons';
const PERSON_ADD = 'http://localhost:8080/persons/add/';

class PersonsService {
    getPersons() {
        return axios.get(PERSON_GET);
    }

    addPerson(person) {
        // const jsonPerson = JSON.stringify(person);
        console.log(person)
        axios.post(PERSON_ADD, person).then(res => {});
    }
}

export default new PersonsService();