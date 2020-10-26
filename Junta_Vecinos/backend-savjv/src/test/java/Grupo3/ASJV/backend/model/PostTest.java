package Grupo3.ASJV.backend.model;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PostTest {


    @Test
    void getId() {
        Municipality municipality = new Municipality("testname","testcommune");
        Neighborhood neighborhood = new Neighborhood(municipality, "testname");
        User usurious = new User("testnombre","testpass","testmail", neighborhood);
        Date horaactual = Date.from(Instant.now());
        Post posteo = new Post("titulotest","descripciontest",usurious, "categorytest",horaactual, "pricetest");
        ObjectId primerid = new ObjectId();
        posteo.setId(primerid);
        assertEquals(primerid,posteo.getId());
    }

    @Test
    void setId() {
        Municipality municipality = new Municipality("testname","testcommune");
        Neighborhood neighborhood = new Neighborhood(municipality, "testname");
        User usurious = new User("testnombre","testpass","testmail", neighborhood);
        Date horaactual = Date.from(Instant.now());
        Post posteo = new Post("titulotest","descripciontest",usurious, "categorytest",horaactual, "pricetest");
        ObjectId primerid = new ObjectId();
        posteo.setId(primerid);
        assertEquals(primerid,posteo.getId());
    }

    @Test
    void getTitle() {
        Municipality municipality = new Municipality("testname","testcommune");
        Neighborhood neighborhood = new Neighborhood(municipality, "testname");
        User usurious = new User("testnombre","testpass","testmail", neighborhood);
        Date horaactual = Date.from(Instant.now());
        Post posteo = new Post("titulotest","descripciontest",usurious, "categorytest",horaactual, "pricetest");
        assertEquals("titulotest",posteo.getTitle());
    }

    @Test
    void setTitle() {
        Municipality municipality = new Municipality("testname","testcommune");
        Neighborhood neighborhood = new Neighborhood(municipality, "testname");
        User usurious = new User("testnombre","testpass","testmail", neighborhood);
        Date horaactual = Date.from(Instant.now());
        Post posteo = new Post("titulotest","descripciontest",usurious, "categorytest",horaactual, "pricetest");
        posteo.setTitle("titulotest");
        assertEquals("titulotest",posteo.getTitle());
    }

    @Test
    void getDescription() {
        Municipality municipality = new Municipality("testname","testcommune");
        Neighborhood neighborhood = new Neighborhood(municipality, "testname");
        User usurious = new User("testnombre","testpass","testmail", neighborhood);
        Date horaactual = Date.from(Instant.now());
        Post posteo = new Post("titulotest","descripciontest",usurious, "categorytest",horaactual, "pricetest");
        assertEquals("descripciontest",posteo.getDescription());
    }

    @Test
    void setDescription() {
        Municipality municipality = new Municipality("testname","testcommune");
        Neighborhood neighborhood = new Neighborhood(municipality, "testname");
        User usurious = new User("testnombre","testpass","testmail", neighborhood);
        Date horaactual = Date.from(Instant.now());
        Post posteo = new Post("titulotest","descripciontest",usurious, "categorytest",horaactual, "pricetest");
        posteo.setDescription("descripciontest");
        assertEquals("descripciontest",posteo.getDescription());
    }

    @Test
    void getTimestamp() {
        Municipality municipality = new Municipality("testname","testcommune");
        Neighborhood neighborhood = new Neighborhood(municipality, "testname");
        User usurious = new User("testnombre","testpass","testmail", neighborhood);
        Date horaactual = Date.from(Instant.now());
        Post posteo = new Post("titulotest","descripciontest",usurious, "categorytest",horaactual, "pricetest");
        assertNotNull(posteo.getTimestamp());

    }

    @Test
    void setTimestamp() {
        Municipality municipality = new Municipality("testname","testcommune");
        Neighborhood neighborhood = new Neighborhood(municipality, "testname");
        User usurious = new User("testnombre","testpass","testmail", neighborhood);
        Date horaactual = Date.from(Instant.now());
        Post posteo = new Post("titulotest","descripciontest",usurious, "categorytest",horaactual, "pricetest");
        Date horaactual2 = Date.from(Instant.now());
        posteo.setTimestamp(horaactual2);
        assertNotNull(posteo.getTimestamp());
    }

    @Test
    void getSell() {
        Municipality municipality = new Municipality("testname","testcommune");
        Neighborhood neighborhood = new Neighborhood(municipality, "testname");
        User usurious = new User("testnombre","testpass","testmail", neighborhood);
        Date horaactual = Date.from(Instant.now());
        Post posteo = new Post("titulotest","descripciontest",usurious, "categorytest",horaactual, "pricetest");
    }

    @Test
    void setSell() {
        Municipality municipality = new Municipality("testname","testcommune");
        Neighborhood neighborhood = new Neighborhood(municipality, "testname");
        User usurious = new User("testnombre","testpass","testmail", neighborhood);
        Date horaactual = Date.from(Instant.now());
        Post posteo = new Post("titulotest","descripciontest",usurious, "categorytest",horaactual, "pricetest");
    }

    @Test
    void getUser() {
        Municipality municipality = new Municipality("testname","testcommune");
        Neighborhood neighborhood = new Neighborhood(municipality, "testname");
        User usurious = new User("testnombre","testpass","testmail", neighborhood);
        Date horaactual = Date.from(Instant.now());
        Post posteo = new Post("titulotest","descripciontest",usurious, "categorytest",horaactual, "pricetest");
        assertEquals(usurious,posteo.getUser());
    }

    @Test
    void setUser() {
        Municipality municipality = new Municipality("testname","testcommune");
        Neighborhood neighborhood = new Neighborhood(municipality, "testname");
        User usurious = new User("testnombre","testpass","testmail", neighborhood);
        User usuario2 = new User("testnombre","testpass","testmail", neighborhood);
        Date horaactual = Date.from(Instant.now());
        Post posteo = new Post("titulotest","descripciontest",usurious, "categorytest",horaactual, "pricetest");
        posteo.setUser(usuario2);
        assertEquals(usuario2,posteo.getUser());
    }


}