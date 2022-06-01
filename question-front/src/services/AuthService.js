import axios from 'axios';

const AUTH_URL = 'http://localhost:8080';

class AuthService {
    login(user) {
        debugger
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
    logout() {
        localStorage.removeItem('user');
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
}
export default new AuthService();