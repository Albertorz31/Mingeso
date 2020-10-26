<template>
    <div>
        <h1>Estudiantes - Pep 1</h1>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">Nombre</th>
                    <th scope="col">Rut</th>
                    <th scope="col">Fecha de nacimiento</th>
                    <th scope="col">Carrera</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="(student, id) in students" :key="id">
                    <td>{{student.name}}</td>
                    <td>{{student.rut}}</td>
                    <td>{{student.birthdate}}</td>
                    <td>{{student.career.name}}</td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
import axios from 'axios'

export default{
    title: "lista",
    data() {
        return{
            students: [],
        };
    },

    mounted(){
        this.getStudents();
    },

    methods: {
        getStudents(){
            axios.get('http://159.89.225.254:8080/student')
               .then(response => {
                   this.students = response.data;
               })
               .catch(e => {
                        console.log(e);
                    });
        },

        update(){
            this.getStudents();
        }
    }

};
</script>

