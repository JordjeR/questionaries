import axios from "axios";
import authHeader from "@/auth-header";

const API_URL = 'http://localhost:8080/';

class UserService {
    getPublicContent() {
        return axios.get(API_URL + 'all');
    }
    getUserBoard() {
        return axios.get(API_URL + 'api/persons'/*, { headers: authHeader() }*/);
        /*return axios.get(API_URL, (req, res) => {
            res.set('Access-Control-Allow-Origin', 'http://localhost:8080');
            req.send({
                headers: authHeader()
            })
        });*/
    }
    getModeratorBoard() {
        return axios.get(API_URL + 'mod', { headers: authHeader() });
    }
    getAdminBoard() {
        return axios.get(API_URL + 'admin', { headers: authHeader() });
    }
}
export default new UserService();