<template>
  <div>
    <h4 class="mb-3">Anuncios</h4>
    <b-row>
      <b-col v-for="(post,id) in filterPosts" :key="id" class="mb-3" cols="12" md="6" lg="4" sm="10">
        <b-card no-body style="max-width: 20rem;"
                img-src="https://irp-cdn.multiscreensite.com/55d07fd3/anunciosadwords.jpeg"
                img-alt="Image"
                img-top>

          <b-card-body>
            <b-card-title>{{post.title}}</b-card-title>
            <b-card-sub-title class="mb-2">{{post.category}}</b-card-sub-title>
            <b-card-text>{{post.description}}</b-card-text>
          </b-card-body>

          <b-list-group flush>
            <b-list-group-item>Creado por: {{post.user.username}}</b-list-group-item>
            <b-list-group-item>Email de contacto: {{post.user.mail}}</b-list-group-item>
            <b-list-group-item>Precio: ${{post.price}}</b-list-group-item>
            <b-list-group-item>Fecha: {{dateTransform(post.timestamp)}}</b-list-group-item>
          </b-list-group>
          <b-list-group-item><h5>Comentarios:</h5></b-list-group-item>
          <ShowCommentsFeed :currentPost="post" />
        </b-card>
      </b-col>
    </b-row>
  </div>
</template>

<script>
    import ShowCommentsFeed from '@/components/ShowCommentsFeed.vue';
    import moment from 'moment'
    export default {
        name: 'ShowAnnouncementFeed',
        props: {
            filterPosts: Array
        },
        data (){
          return {
          }
        },
        methods: {
            dateTransform(postDate){
                return moment(String(postDate)).format('MM/DD/YYYY');
            }
        },
        components: {
          ShowCommentsFeed
        }
    }
</script>