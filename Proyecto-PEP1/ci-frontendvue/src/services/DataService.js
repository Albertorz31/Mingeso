import http from "../http-common";

class TutorialDataService {
  getAll() {
    return http.get("/student");
  }

  get(id) {
    return http.get(`/student/${id}`);
  }

  create(data) {
    return http.post("/student", data);
  }

  /*
  update(id, data) {
    return http.put(`/tutorials/${id}`, data);
  }

  delete(id) {
    return http.delete(`/tutorials/${id}`);
  }

  deleteAll() {
    return http.delete(`/tutorials`);
  }

  findByTitle(title) {
    return http.get(`/tutorials?title=${title}`);
  }
  */
}

export default new TutorialDataService();
