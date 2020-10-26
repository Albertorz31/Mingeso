<template>
    <div>
        <h1>Carreras</h1>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">Nombre</th>
                    <th scope="col">Código</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="(career, id) in careers" :key="id">
                    <td>{{career.name}}</td>
                    <td>{{career.cod}}</td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
import axios from 'axios'

export default {
    title: "lista",
    data(){
        return{
            careers: []
        };
    },

    mounted(){
        this.getCareers();
    },

    methods: {
        getCareers(){
            axios.get('http://159.89.225.254:8080/career')
                .then(response=>{
                    this.careers = response.data
                })
                .catch(e => {
                    console.log(e);
                    });
        },
        update(){
            this.getCareers();
        }
    }  
};
</script>