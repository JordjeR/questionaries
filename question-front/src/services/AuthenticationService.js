import axios from 'axios';

const AUTH_URL = 'http://localhost:8080';

class AuthenticationService {
    login(user) {
        return axios
            .post(AUTH_URL + '/auth/login', {
                username: user.username,
                password: user.password
            })
            .then(response => {
                if (response.data.token) {
                    localStorage.setItem('user', JSON.stringify(response.data));
                }
                return response.data;
            });
    }
    register(user) {
        return axios.post(AUTH_URL + '/auth/register', {
            username: user.username,
            firstName: user.firstName,
            lastName: user.lastName,
            login: user.login,
            password: user.password
        });
    }
    logout() {
        localStorage.removeItem('user');
    }
}
export default new AuthenticationService();