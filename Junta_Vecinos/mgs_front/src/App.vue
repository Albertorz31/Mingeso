<template>
    <div id="app">
        <div class="mb-3">
        <b-navbar id="navbar" toggleable="lg" active-class="active" type>
            

            <b-navbar-brand id="textbar" :to="{name: 'Dashboard'}">Anuncios y servicios juntas vecinales</b-navbar-brand>

            <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>
            
            <b-collapse id="nav-collapse" is-nav>
               <!-- Right aligned nav items -->
               <b-navbar-nav class="ml-auto">
                  <b-nav-item v-if="showJuntaVecinosBoard" :to="{name: 'UserList'}">Lista de Anuncios de la Junta</b-nav-item>
                  <b-nav-item v-if="showMunicipalidadBoard" :to="{name: 'VerRanking'}">Ver Rankings</b-nav-item>
                  <b-nav-item :to="{name: 'AnnouncementFeed'}">Anuncios</b-nav-item>
                  <b-nav-item :to="{name: 'HomeCitizen'}">Home Ciudadano</b-nav-item>
               </b-navbar-nav>

               <b-navbar-nav v-if="currentUser">
                  <b-nav-item>
                     <b>{{currentUser.username}}s</b>
                  </b-nav-item> 
                  <li class="nav-item">
                     <a class="nav-link" href @click.prevent="logOut">
                           <font-awesome-icon icon="sign-out-alt" />LogOut
                     </a>
                  </li>
               </b-navbar-nav>

               <b-navbar-nav v-else>
                  <b-nav-item :to="{name: 'Login'}">Iniciar Sesión</b-nav-item>
                  <b-nav-item :to="{name: 'Singup'}">Registrarse</b-nav-item>
               </b-navbar-nav>
            </b-collapse>
        </b-navbar>
        </div>

        <b-container>
        <router-view/>
        </b-container>
        <notifications group="foo"/>
    </div>
</template>

<script>
export default {
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    },
    showMunicipalidadBoard() {
      if (this.currentUser && this.currentUser.roles) {
        return this.currentUser.roles.includes('ROLE_MUNICIPALIDAD');
      }
      return false;
    },
    showJuntaVecinosBoard() {
      if (this.currentUser && this.currentUser.roles) {
        return this.currentUser.roles.includes('ROLE_JUNTAVECINOS');
      }
      return false;
    }
  },
  methods: {
    logOut() {
      this.$store.dispatch('auth/logout');
      this.$router.push('/Login');
    }
  }
};
</script>

<style>
   #navbar{      
      background-color: #ffffff;
      box-shadow: 0px 50px 80px rgba(34, 35, 58, 0.2);
   }
</style>