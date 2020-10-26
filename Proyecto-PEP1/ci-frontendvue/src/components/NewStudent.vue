<template>
    <div class="new-student">
        <h1>Nuevo Alumno</h1>
        <form>
            <div class="form-item">
                <label class="element-borders" for="name">Nombre del alumno</label>
                <el-input class="element-borders" id="name" placeholder="Ingrese nombre del alumno" v-model="student.name"></el-input>

                <label class="element-borders" for="rut">Rut</label>
                <el-input class="element-borders" id="rut" placeholder="Ingrese el rut del alumno" v-model="student.rut"></el-input>

                <label class="element-borders" for="birthdate">Fecha de nacimiento</label>
                <el-date-picker type="date" class="element-borders" id="birthdate" placeholder="Eliga una fecha" v-model="student.birthdate"></el-date-picker>

                <el-divider content-position="left" direction="horizontal"><h3>Carreras a postular</h3></el-divider>

                <el-select class="select-size" 
                v-model="student.career"
                placeholder="ej. Ing. Informática">
                    <el-option v-for="career in careers" 
                    :key="career.name" 
                    :label="career.name" 
                    :value="career">
                    </el-option>
                </el-select>
            </div>
            <div class="button-student">
                <el-button type="primary" round icon="el-icon-upload" @click="save">Ingresar</el-button>
            </div>
        </form>
    </div>
</template>

<script>
import axios from 'axios'
export default {
    data() { 
        return {
            value: "Active",
            student: {  
                name:"",
                rut:"",
                birthdate:"",
                career:{},
                },
            message: "",
            career: "",
            careers: [],
        };
    },

    methods: {
        save: async function(){
            this.message= "";
            if(this.student.name == ""){
                this.message = "Debe ingresar el nombre del alumno";
                this.$notify({
                    title: "Warning",
                    message: "El alumno no tiene nombre",
                    type: "warning"
                });
                return false;
            }
            if(this.student.rut == ""){
                this.message = "Debe ingresar el rut del alumno";
                this.$notify({
                    title: "Warning",
                    message: "El alumno no tiene rut",
                    type: "warning"
                });
                return false;
            }
            if(this.student.birthdate == ""){
                this.$notify({
                    title: "Warning",
                    message: "El alumno no tiene fecha de nacimiento",
                    type: "warning"
                });
                return false
            }
            axios.post('http://159.89.225.254:8080/student', this.student)
            .then(function (response) {
                console.log(response);
                console.log(this.student);
                console.log("Student "+ this.student.name +" added successfully");
                this.$notify({
                    title: "Estudiante ingresado",
                    message: "El estudiante ha sido ingresado correctamente"
                });

            })
            .catch(error=>
                this.$notify.error({
                    title: "Error",
                    message: "No se ha podido ingresar el estudiante. Error: "+ error.message
                })
            )
        },

        dispatch (e) {
            this.$emit('input', e);
            this.student.career = e;
        },

        onSumit() {
            console.log('submit!')
        },

        getCareer: async function(){
            axios.get('http://159.89.225.254:8080/career',{})
            .then(response=>{
                this.careers = response.data;
            })
        },
    },
    created:  function(){
        this.getCareer();
    }
};
</script>

<style scoped>
.new-student{
    box-sizing:content-box;
    padding: 8px 0 0px;
}
.button-student{
    align-items: center;
    display: flex;
    flex-direction: column;
    left: 0;
    margin: 0 auto;
    position: absolute;
    right: 0;
}
.element-borders{
    margin-top: 9px;
    margin-bottom: 3px;
}
.select-size {
  width: 100%;
}
</style>
