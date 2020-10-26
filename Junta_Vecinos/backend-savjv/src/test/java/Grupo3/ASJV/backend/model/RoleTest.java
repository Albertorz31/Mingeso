package Grupo3.ASJV.backend.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoleTest {

    @Test
    void getId() {
        Role rol = new Role(Erole.ROLE_MUNICIPALIDAD);
        rol.setId("123");
        assertEquals("123",rol.getId());

    }

    @Test
    void setId() {
        Role rol = new Role(Erole.ROLE_MUNICIPALIDAD);
        rol.setId("123");
        assertEquals("123",rol.getId());
    }

    @Test
    void getName() {
        Role rol = new Role(Erole.ROLE_MUNICIPALIDAD);
        assertEquals(Erole.ROLE_MUNICIPALIDAD,rol.getName());

    }

    @Test
    void setName() {
        Role rol = new Role(Erole.ROLE_MUNICIPALIDAD);
        rol.setName(Erole.ROLE_CIUDADANO);
        assertEquals(Erole.ROLE_CIUDADANO,rol.getName());

    }
}