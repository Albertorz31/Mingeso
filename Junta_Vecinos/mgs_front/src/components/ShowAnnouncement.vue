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
                        <b-card-title>{{post.price}} $</b-card-title>
                        <b-card-sub-title class="mb-2">{{post.title}}</b-card-sub-title>
                        <b-card-text>
                            {{post.description}} 
                        </b-card-text>
                    </b-card-body>

                    <b-list-group flush>
                        <b-list-group-item>{{post.user.username}}</b-list-group-item>
                        <b-list-group-item>Fecha: {{dateTransform(post.timestamp)}}</b-list-group-item>
                        <b-card-text class="text-center">Comentar <b-icon icon="chat-square"></b-icon></b-card-text>
                    </b-list-group>

                    <ShowComments :currentPost="post" />
                    
                </b-card>
            </b-col>
         </b-row>
    </div>
</template>

<script>
    import ShowComments from '@/components/ShowComments.vue';
    import moment from 'moment'
    export default {
        name: 'ShowAnnouncement',
        data (){
           return {

           }
        },
        props: {
            filterPosts: Array
        },
        methods: {
            dateTransform(postDate){
                return moment(String(postDate)).format('MM/DD/YYYY');
            }
        },
        components: {
           ShowComments
        }
    }
</script>