import Vue from 'vue'
import Router from 'vue-router'
import Home from "./views/Home.vue"
import AddStudent from "./views/AddStudent.vue"
import ListStudents from "@/components/ListStudents.vue"
import ListCareers from "@/components/ListCareers.vue"


Vue.use(Router)
export default new Router({
  mode: "history",
  routes: [
    {
      path: "/",
      name: "home",
      component: Home
    },

    {
      path: "/students/add",
      name: "addStudent",
      component: AddStudent
    },

    {
      path: "/students",
      name: "ListStudents",
      component: ListStudents
    },
    {
      path: "/careers",
      name: "ListCareers",
      component: ListCareers
    }
  ]
});
