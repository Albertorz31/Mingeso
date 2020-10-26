import axios from 'axios';
import authHeader from './auth-header';

//const API_URL = 'http://localhost:8080/api/test/'; //LOCAL
const API_URL = 'http://104.248.117.251:8080/api/test/'; //Droplet

class UserService {
  getPublicContent() {
    return axios.get(API_URL + 'all');
  }

  getUserBoard() {
    return axios.get(API_URL + 'ciudadano', { headers: authHeader() });
  }

  getModeratorBoard() {
    return axios.get(API_URL + 'municipalidad', { headers: authHeader() });
  }

  getAdminBoard() {
    return axios.get(API_URL + 'juntavecinos', { headers: authHeader() });
  }
}

export default new UserService();