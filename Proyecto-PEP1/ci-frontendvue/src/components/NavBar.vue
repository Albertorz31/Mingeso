<template>
    <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect" background-color="#545c64"  text-color="#fff" active-text-color="#ffd04b">
        <el-menu-item index="1">
            <router-link to="/" style="text-decoration:none">Inscripción de Asignaturas</router-link>
        </el-menu-item>
        <el-menu-item index="2">
            <router-link to="/students" style="text-decoration:none">Listado de Alumnos</router-link>
        </el-menu-item>
        <el-menu-item index="3">
            <router-link to="/students/add" style="text-decoration:none">Ingresar Alumno</router-link>
        </el-menu-item>
        <el-menu-item index="4">
            <router-link to="/careers" style="text-decoration:none"> Ver Carreras</router-link>
        </el-menu-item>
    </el-menu>
</template>

<script>
export default{
  data() {
    return {
      activeIndex: '1',
    };
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    }
  }
}
</script>
