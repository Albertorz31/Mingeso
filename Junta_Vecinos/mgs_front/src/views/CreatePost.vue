<template>
   <div align="center">
      <b-card border-variant="secondary"
            header="Crear Anuncio"
            header-border-variant="secondary"
            style="max-width: 50rem;">
         <b-row>     
         <b-col sm="1"></b-col>    
         <b-col sm="10" align="left">
            <b-form @submit="onSubmit" @reset="onReset" v-if="show">
            <b-form-group id="input-group-1" label="Título:" label-for="input-1">
               <b-form-input id="input-1" v-model="form.title" type="text" required placeholder="Ingrese el nombre del anuncio"></b-form-input>
            </b-form-group>

            <b-form-group id="input-group-2" label="Descripción:" label-for="input-2">
               <b-form-textarea id="input-2" v-model="form.description" required placeholder="Ingrese la descipción del anuncio"></b-form-textarea>
            </b-form-group>

            <b-form-group id="input-group-4" label="Categoría:" label-for="input-4">
                <b-form-select id="input-4" v-model="form.category" :options="categories" required></b-form-select>
            </b-form-group>

            <b-form-group id="input-group-5" label="Precio:" label-for="input-5">
               <b-form-input id="input-5" v-model="form.price" required
                  placeholder="Ingrese el precio"
               ></b-form-input>
            </b-form-group>

            
            <b-row class="text-center mt-4">
               <b-col>
                  <b-button type="submit" variant="primary" @click="save">Crear anuncio</b-button>
               </b-col>
               <b-col >
                  <b-button variant="outline-danger" @click="goToHomeCitizen">Cancelar</b-button>
               </b-col>
            </b-row>
            </b-form>
         </b-col>
         <b-col sm="1"></b-col>    
         </b-row>
      </b-card>
      
   </div>
</template>

<script>
import axios from 'axios'
import router from '@/router';

  export default {
     name: 'CreatePost',
     computed:{
        currentUser(){
         return this.$store.state.auth.user;
         }
      },
      mounted(){
         if(!this.currentUser){
            this.$router.push('/login');
         }
      },
     data() {
        return {
            form: {title: "", description: "", user_id: this.$store.state.auth.user.id, category: null, price: ""},
            foods: [{ value: null, text: 'Nombre usuario actual' }],
            show: true,
            categories: [{text: 'Seleccionar Uno', value: null}, 'Alimentacion', 'Hogar', 'Mascota', 'Autos', 'Otros'],
            message: ""
      }
    },
    methods: {
      onSubmit(evt) {
        evt.preventDefault()
      },
      onReset(evt) {
        evt.preventDefault()
        // Reset our form values
        this.form.title = ''
        this.form.description = ''
        this.form.user = null
        // Trick to reset/clear native browser form validation state
        this.show = false
        this.$nextTick(() => {
          this.show = true
        })
      },
      save(){
         this.message = "";
         axios.post('http://104.248.117.251:8080/post', this.form).then(function(response){
            console.log(response);
            router.push({ name: 'HomeCitizen' });
         });
      },
      goToHomeCitizen(){
         router.push({name: 'HomeCitizen'});
      }
    }
  }
</script>
