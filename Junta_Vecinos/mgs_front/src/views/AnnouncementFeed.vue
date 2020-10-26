<template>
    <div>
        <b-container>
          <b-row>
            <b-col sm="5">
              <span>Filtrar por:</span>
              <b-form-select v-model="selectedC" :options="categories" class="mb-3 mt-1"></b-form-select>
              <b-button variant="outline-primary" size="sm" @click="postFilter(selectedC)">Aplicar</b-button>
            </b-col>

            <b-col sm="10">
              <ShowAnnouncementFeed v-if="filterV === 0" :filterPosts="posts"/>
              <ShowAnnouncementFeed v-else :filterPosts="postsFil"/>
            </b-col>
          </b-row>
        </b-container>
    </div>
</template>

<script>
    import ShowAnnouncementFeed from '@/components/ShowAnnouncementFeed.vue';
    import axios from 'axios';
    export default {
      name: 'AnnouncementFeed',
      data() {
        return {
          posts: [],
          selectedC: null,
          categories: [
            {value: null, text: '-- Categorías --'},
            {value: 'Hogar', text: 'Hogar'},
            {value: 'Alimentacion', text: 'Alimentacion'},
            {value: 'Mascota', text: 'Mascota'},
            {value: 'Otros', text: 'Otros'}
          ],
          order: [
            {value: null, text: 'Defecto'},
            {value: 1, text:'Más reciente'}
          ],
          postsFil: [],
          filterV: 0
        }
      },
      methods: {
        async getPosts() {
          axios.get('http://104.248.117.251:8080/post')
              .then((response) => {
                console.log(response.data);
                this.posts = response.data;
              })
              .catch((error) => {
                console.log(error)
              });
        },
        postFilter(categ){
          this.filterV = 0;
          if(categ != null){
            axios.get('http://104.248.117.251:8080/post')
                .then((response) => {
                  console.log(response.data);
                  this.posts = response.data;
                })
                .catch((error) => {
                  console.log(error)
                })
            let postsLen = this.posts.length;
            let i = 0;
            this.postsFil = [];
            while(i < postsLen){
              if(this.posts[i].category === categ){
                this.postsFil.push({
                  id: this.posts[i].id,
                  title: this.posts[i].title,
                  description: this.posts[i].description,
                  user: this.posts[i].user,
                  category: this.posts[i].category,
                  comments: this.posts[i].comments,
                  timestamp: this.posts[i].timestamp,
                  price: this.posts[i].price
                });
              }
              i = i + 1;
            }
            this.filterV = 1;
          }
        },
      },
        
        components: {
            ShowAnnouncementFeed
        },
        
        created() {
            this.getPosts();
        }
    }
</script>