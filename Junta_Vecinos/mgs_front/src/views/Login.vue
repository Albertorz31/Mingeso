<template>
  <div class="vue-tempalte">
    <form name="form" @submit.prevent="handleLogin">
      <h3>Iniciar sesión</h3>

      <div class="form-group">
        <label for="username">Nombre de usuario</label>
        <input
          v-model="user.username"
          v-validate="'required'"
          type="text"
          class="form-control"
          name="username"
        />
      </div>

      <div class="form-group">
        <label for="password">Contraseña</label>
        <input 
          v-model="user.password"
          v-validate="'required'"
          type="password"
          class="form-control"
          name="password"
        />
      </div>
      <div class="form-group">
        <button class="btn btn-primary btn-block" :disabled="loading">
          <span v-show="loading" class="spinner-border spinner-border-sm"></span>
          <span>Iniciar sesión</span>
        </button>
      </div>
      <div class="form-group">
          <div v-if="message" class="alert alert-danger" role="alert">{{message}}</div>
      </div>

      <p class="forgot-password text-right mt-2 mb-4">
        <router-link to="/forgot-password">Olvidé mi contraseña</router-link>
      </p>

    </form>

  </div>
</template>

<script>
import User from '../models/user';
export default {
  name: 'Login',
  data() {
    return {
      user: new User('', ''),
      loading: false,
      message: '',
    };
  },
  computed: {
    loggedIn() {
      return this.$store.state.auth.status.loggedIn;
    }
  },
  created() {
    if (this.loggedIn) {
      this.$router.push('/homecitizen');
    }
  },
  methods: {
    handleLogin() {
      this.loading = true;
      this.$validator.validateAll().then(isValid => {
        if (!isValid) {
          this.loading = false;
          return;
        }
        if (this.user.username && this.user.password) {
          this.$store.dispatch('auth/login', this.user).then(
            () => {
              this.$router.push('/homecitizen');
            },
            error => {
              this.loading = false;
              this.message = "El nombre de usuario y/o la contraseña no coinciden con algun usuario registrado. Vuelva a intentar."
            }
          );
        }
      });
    }
  }
};
</script>
