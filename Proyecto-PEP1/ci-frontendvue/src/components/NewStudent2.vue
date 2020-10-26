
<template>
<div class="submit-form">
    <h1>Nuevo Alumno</h1>
    <div v-if="!submitted">
        <div class="submit-form">
            <div class="form-item">
                <label for="name">Name:</label><br>
                <input type="text" 
                class="form-control"
                id="name" 
                required v-model="student.name"
                name="name"
                />
            </div>

            <div class="form-item">
                <label for="rut">Rut:</label><br>
                <input type="text" 
                class="form-control"
                id="rut" 
                required v-model="student.rut"
                name="rut"
                />
            </div>

            <div class="form-item">
                <label for="birthdate">Fecha de nacimiento:</label><br>
                <input type="date" 
                class="form-control"
                id="birthdate" 
                required v-model="student.birthdate"
                name="birthdate"
                />
            </div>

            <div class="form-item">
                <label for="career">Carrera a postular:</label><br>
                <input placeholder="Selecciona una carrera" @input="saveSelectionAndReset" list="list"/>
                    <datalist id="list">
                        <option v-for="career in careers" v-bind:key="career.id" :value="career.name"></option>
                    </datalist>
                    <p>{{selectedCareer || 'Ninguna carrera seleccionada'}}</p>
            </div>
        </div>
        <button @click="saveStudent" class="btn btn-success">Submit</button>
    </div>
</div>
</template>

<script>
import axios from 'axios';
import DataService from "../services/DataService";
export default {
    name: "add-student",
    data() {
        return {
            student: {
                id: null,
                name: "",
                rut: "",
                birthdate: "",
                published: false
            },
            careers: [],
            career: "",
            selectedCareer: "",
            submitted: false
        };
    },
    methods: {
        saveSelectionAndReset(e) {
            let val = e.target.value;
            if (val) {
                this.selectedCareer = val;
                console.log(this.selectedCareer);
            }
            e.target.value = "";
        },
        saveStudent() {
            var data = {
                name: this.student.name,
                rut: this.student.rut,
                birthdate: this.student.birthdate
            };

            DataService.create(data)
                .then(response => {
                    this.student.id = response.data.id;
                    console.log(response.data);
                    this.submitted = true;
                })
                .catch(e => {
                    console.log(e);
                });
        },

        newStudent() {
            this.submitted = false;
            this.student = {};
        },

        getCareers: async function(){
            axios.get('http://localhost:8080/career',{})
            .then(response=>{
                this.careers = response.data;
            })
        }
    },
    created:  function(){
        this.getCareers();
    }
};
</script>

<style>
.submit-form {
  max-width: 300px;
  margin: auto;
}
</style>