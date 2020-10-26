<template>
    <div>
        <b-container class="mb-5">
            <b-row>
                <b-col sm="10">
                    <ShowAnnouncement v-if="filterV === 0" :filterPosts="posts"/>
                    <ShowAnnouncement v-else :filterPosts="postsFil"/>
                </b-col>

                <b-col sm="2" class="mt-5 text-left" >
                    <b-button variant="link" @click="goToCreatePost">Crear anuncio</b-button>
                    <b-button variant="link">Destacados</b-button>
                    <b-button variant="link">Opciones</b-button>
                    <b-form-select v-model="selectedC" :options="categories" class="mb-3 mt-1"></b-form-select>
                    <b-form-select v-model="selectedD" :options="order" class="mb-3"></b-form-select>
                    <b-button variant="outline-primary" size="sm" @click="postFilter(selectedC, selectedD)">Aplicar</b-button>
                </b-col>
            </b-row>
        </b-container>
    </div>
</template>

<script>
    import ShowAnnouncement from '@/components/ShowAnnouncement.vue';
    import router from '@/router';
    import axios from "axios";
    export default {
        name: 'HomeCitizen',
        data(){
            return{
                posts: [],
                selectedC: null,
                selectedD: null,
                categories: [
                    { value: null, text: '-- Categorías --' },
                    { value: 'Hogar', text: 'Hogar'},
                    { value: 'Alimentacion', text: 'Alimentacion'},
                    { value: 'Mascota', text: 'Mascota'},
                    { value: 'Otros', text: 'Otros'},
                ],
                order: [
                    { value: null, text: '-- Fecha --' },
                    { value: 1, text: 'Ascendente' },
                    { value: 2, text: 'Descendente' }
                ],
                postsFil: [],
                filterV: 0
            }
        },
        // mounted(){
        //     this.getPosts();
        // },
        methods: {
            async getPosts(){
                axios.get('http://104.248.117.251:8080/post')
                .then(response => {
                    this.posts = response.data;
                })
                .catch(e => {
                    console.log(e);
                });
            },
            // update(){
            //     this.getPosts();
            // },
            async getCategories(){
                let categoriesData = await axios.get('');
                this.categories = await categoriesData.data;
            },
            
            postFilter(categ, sort){
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
            goToCreatePost () {
                router.push({ name: 'CreatePost' })
            }
        },

        components: {
            ShowAnnouncement
        },

        created (){
            this.getPosts();
        }
    }
</script>