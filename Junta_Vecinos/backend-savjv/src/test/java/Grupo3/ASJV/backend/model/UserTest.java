package Grupo3.ASJV.backend.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {



    @Test
    void getMail() {
        Municipality municipality = new Municipality("testname","testcommune");
        Neighborhood neighborhood = new Neighborhood(municipality, "testname");
        User usurious = new User("testnombre","testpass","testmail", neighborhood);
        assertEquals("testmail", usurious.getMail());
    }

    @Test
    void setMail() {
        Municipality municipality = new Municipality("testname","testcommune");
        Neighborhood neighborhood = new Neighborhood(municipality, "testname");
        User usurious = new User("testnombre","testpass","testmail", neighborhood);
        usurious.setMail("testmail");
        assertEquals("testmail", usurious.getMail());

    }

    @Test
    void getId() {
        Municipality municipality = new Municipality("testname","testcommune");
        Neighborhood neighborhood = new Neighborhood(municipality, "testname");
        User usurious = new User("testnombre","testpass","testmail", neighborhood);
        usurious.setId(10101);
        assertEquals(10101,(long)usurious.getId());
    }

    @Test
    void setId() {
        Municipality municipality = new Municipality("testname","testcommune");
        Neighborhood neighborhood = new Neighborhood(municipality, "testname");
        User usurious = new User("testnombre","testpass","testmail", neighborhood);
        usurious.setId(10101);
        assertEquals(10101,(long)usurious.getId());
    }

    @Test
    void getPassword() {
        Municipality municipality = new Municipality("testname","testcommune");
        Neighborhood neighborhood = new Neighborhood(municipality, "testname");
        User usurious = new User("testnombre","testpass","testmail", neighborhood);
        assertEquals("testpass", usurious.getPassword());
    }

    @Test
    void setPassword() {
        Municipality municipality = new Municipality("testname","testcommune");
        Neighborhood neighborhood = new Neighborhood(municipality, "testname");
        User usurious = new User("testnombre","testpass","testmail", neighborhood);
        usurious.setPassword("testpass");
        assertEquals("testpass", usurious.getPassword());
    }

    @Test
    void getUsername() {
        Municipality municipality = new Municipality("testname","testcommune");
        Neighborhood neighborhood = new Neighborhood(municipality, "testname");
        User usurious = new User("testnombre","testpass","testmail", neighborhood);
        assertEquals("testnombre", usurious.getUsername());
    }

    @Test
    void setUsername() {
        Municipality municipality = new Municipality("testname","testcommune");
        Neighborhood neighborhood = new Neighborhood(municipality, "testname");
        User usurious = new User("testnombre","testpass","testmail", neighborhood);
        usurious.setUsername("testpass");
        assertEquals("testpass", usurious.getUsername());
    }
}