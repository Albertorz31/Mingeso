<template>
   <div>
      <b-container class="mb-5">

         <b-carousel
            id="carousel-fade"
            class="mb-4"
            style="text-shadow: 0px 0px 2px #000"
            fade
            indicators
            img-width="1024"
            img-height="480"
         >
            <b-carousel-slide
               caption=""
               img-src="https://pbs.twimg.com/media/EiMmB6_XkAAK660?format=png&name=medium"
            ></b-carousel-slide>
            <b-carousel-slide
               caption=""
               img-src="https://pbs.twimg.com/media/EiMmB7lX0AMH8Pl?format=png&name=medium"
            ></b-carousel-slide>
            <b-carousel-slide
               caption=""
               img-src="https://pbs.twimg.com/media/EiMmB75WsAAwwdB?format=png&name=medium"
            ></b-carousel-slide>
         </b-carousel>


         <b-jumbotron>
            <template v-slot:header>Información importante</template>

            <template v-slot:lead>
              Para enfrentar al coronavirus, las recomendaciones principales son el distanciamiento físico y el lavado de manos regular con jabón o, en su ausencia, alcohol gel.
            </template>

            <hr class="my-4">

            <p>
               Informacion relacionada al COVID-19, ¡informese vecino!
            </p>

            <b-button variant="primary" href="https://www.gob.cl/coronavirus/cifrasoficiales/">Estadísticas oficiales</b-button>
            <b-button variant="success" href="https://www.google.com/maps/d/u/0/viewer?mid=1y7LnezVdq7ZgFiB-cC9WizNJaA2ybDk3&ll=-33.50053550410916%2C-68.86242306277813&z=6">Mapa del "paso a paso"</b-button>
         </b-jumbotron>

        <h2 class="mt-0">Último anuncio publicado</h2>
         <b-card>
            <b-media>
               <template v-slot:aside>
                  <b-img blank blank-color="#ccc" width="64" alt="placeholder"></b-img>
               </template>
               <h5><div id="app">{{posts[posts.length - 1].title}}</div></h5>
                <p><div id="app2">Descripcion:{{posts[posts.length - 1].description}}</div>
                  <div id="app3">Publicado por {{posts[posts.length - 1].user.username}} el dia {{ dateTransform(posts[posts.length - 1].timestamp)}}</div>
                  <div id="app4">Medio de contacto: {{posts[posts.length - 1].user.mail}}</div>
                </p>
            </b-media>
         </b-card>
      </b-container>
   </div>
</template>

<script>
import axios from 'axios';
import moment from "moment";
export default {
  name: 'Dashboard',
  data() {
    return {
      posts: [],
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
    dateTransform(postDate){
      return moment(String(postDate)).format('MM/DD/YYYY');
    }
    },
  created() {
    this.getPosts();
  }
  }
</script>