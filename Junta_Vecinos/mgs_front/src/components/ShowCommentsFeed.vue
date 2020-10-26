<template>
  <div>
    <b-card-body>
      <div class="mb-3" v-for="comment in currentPost.comments" :key="comment.id">
        <b-card-sub-title>> {{comment.user.username}} / {{comment.user.mail}}</b-card-sub-title>
        <b-card-text><h6> - {{comment.content}}</h6></b-card-text>
      </div>
    </b-card-body>
  </div>
</template>

<script>
export default {
  name: 'ShowComments',
  data(){
    return {
      text: '',
      modalShow: false,
      form: {content: '', user: '', timestamp: ''}
    }
  },

  methods: {
    addComment(){
      // funcion que agrega un comentario en un post
      if (!this.currentUser){
        this.$router.push('/login');
        return
      }
      if (this.text == ''){
        return
      }
      this.modalShow = true;
      this.form.content = this.text;
      this.form.user = this.$store.state.auth.user;
      this.form.timestamp = '';
      axios.post('http://104.248.117.251:8080/post/comments/' + this.currentPost._id, this.form).then(function(response){
        console.log(response);
      });
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

