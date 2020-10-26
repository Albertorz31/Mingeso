<template>
  <div class="vue-tempalte">
    <form>
      <h3>Registrar cuenta</h3>

      <div class="form-group">
        <label>Usuario</label>
        <input type="text" class="form-control form-control-lg"/>
      </div>

      <div class="form-group">
        <label>Dirección de correo electrónico</label>
        <input type="email" class="form-control form-control-lg" placeholder="alguien@micorreo.cl"/>
      </div>

      <div class="form-group">
        <label>Contraseña</label>
        <input type="password" class="form-control form-control-lg" />
        <small class="form-text text-muted">La contraseña no debe de tener caracteres especiales, solo números y letras</small>
      </div>

      <button type="submit" class="btn btn-dark btn-lg btn-block">Registrar</button>

      <p class="forgot-password text-right">
        Ya posee una cuenta?,
        <router-link to="/login"> inicie sesión</router-link>
      </p>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {}
  }
}
</script>