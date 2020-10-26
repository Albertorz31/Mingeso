<template>
    <div>
        <b-container class="mb-5">
            <b-row>
                <b-col sm="10">
                    <h4 class="mb-3">Anuncios - {{this.$store.state.auth.user.neighborhood.name}}</h4>
                    <b-row>
                        <b-col v-for="(post,id) in postFil" :key="id" class="mb-3" cols="12" md="6" lg="4" sm="10">
                            <b-card no-body style="max-width: 20rem;"
                                img-src="https://irp-cdn.multiscreensite.com/55d07fd3/anunciosadwords.jpeg"
                                img-alt="Image"
                                img-top>
                                <b-card-body>
                                    <b-card-title>{{post.price}} $</b-card-title>
                                    <b-card-sub-title class="mb-2">{{post.title}}</b-card-sub-title>
                                    <b-card-text>
                                        {{post.description}} 
                                    </b-card-text>
                                </b-card-body>
                                <b-list-group flush>
                                    <b-list-group-item>{{post.user.username}}</b-list-group-item>
                                    <b-list-group-item>Fecha: {{dateTransform(post.timestamp)}}</b-list-group-item>
                                    <b-button v-b-modal="'modal-1'" variant="danger" block size="sm" @click="deletePost(post.id)">Eliminar</b-button>
                                </b-list-group>
                            </b-card>
                        </b-col>          
                    </b-row>
                </b-col>
            </b-row>
        </b-container>

    </div>
</template>


<script>
    import router from '@/router';
    import axios from "axios";
    import moment from 'moment'
    export default {
        name: 'UserList',
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
        data(){
            return{
                posts: [],
                postFil: []
            }
        },
        methods:{
            async postFilter(){
                axios.get('http://104.248.117.251:8080/post')
                    .then(response => {
                        this.posts = response.data;
                        let postsLen = this.posts.length;
                        let i = 0;     
                        while(i < postsLen){
                            if(this.posts[i].user.username == this.$store.state.auth.user.username){
                                this.$store.state.auth.user.neighborhood= this.posts[i].user.neighborhood
                                break
                            }
                            i=i+1
                        }
                        i=0
                        let id = this.$store.state.auth.user.neighborhood.id;
                        while(i < postsLen){
                            try{
                                if(this.posts[i].user.neighborhood.id == id){
                                this.postFil.push({
                                    id: this.posts[i]._id,
                                    title: this.posts[i].title,
                                    description: this.posts[i].description,
                                    user: this.posts[i].user,
                                    category: this.posts[i].category,
                                    timestamp: this.posts[i].timestamp,
                                    price: this.posts[i].price
                                    });
                                }
                            }
                            catch{
                                console.log("holo")
                            }
                            i=i+1
                        }
                    })
                    .catch(e => {
                        console.log(e);
                    })
            },
            deletePost(id){  

                let varToken = this.$store.state.auth.user.accessToken;
                const headers = {
                    'Content-Type': 'application/json',
                    'Authorization': 'Bearer ' + varToken
                }
                //Función que eliminar la publicación
                axios.delete('http://104.248.117.251:8080/post/'+id, { headers: headers})
                    .then(response =>{
                        console.log(response);    
                    })
                    .catch(e => {
                        console.log('deletePost', e, e.response)
                    })  
            },
            dateTransform(postDate){
                return moment(String(postDate)).format('MM/DD/YYYY');
            }
        },
        
        created(){
            this.postFilter();
        }
    }
</script>