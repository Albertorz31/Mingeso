<template>
   <div>
      <b-card-body>
         <div class="mb-3" v-for="comment in currentPost.comments" :key="comment.id">
            <b-card-sub-title>{{comment.user}}</b-card-sub-title>
            <b-card-text>{{comment.descrip}}</b-card-text>
         </div>
         <b-card-text>
            <b-card-sub-title>
               <b-icon icon="person-fill"></b-icon>
               UsuarioActual
               <b-form-input v-model="text" placeholder="Escribe un comentario..."></b-form-input>
            </b-card-sub-title>
         </b-card-text>
         <b-card-text>
            <b-button v-b-modal="'modal-1'" variant="outline-primary" block size="sm" @click="addComment()">Comentar</b-button>
         </b-card-text>
      </b-card-body>
      <b-modal v-model="modalShow" title="Anuncios" ok-only @ok="reloadPage">
            <p class="my-4">Su comentario fue creado exitosamente!</p>
      </b-modal>
   </div>
</template>

<script>
export default {
   name: 'ShowComments',
   data(){
      return {
         text: '',
         modalShow: false
      }
   },

   methods: {
      addComment(){
         // funcion que agrega un comentario en un post
         if (this.text == ''){
            return
         }
         this.modalShow = true;
      },

      reloadPage(){
         // funcion que actualiza la vista comentarios
         this.text = '';
         this.$router.go();
      }
   },

   props: {
      currentPost: Array
   }
}
</script>

