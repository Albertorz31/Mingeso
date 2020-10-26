package Grupo3.ASJV.backend.model;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CommentTest {

    @Test
    void getId() {
        Municipality municipality = new Municipality("testname","testcommune");
        Neighborhood neighborhood = new Neighborhood(municipality, "testname");
        User usurious = new User("testnombre","testpass","testmail", neighborhood);
        Comment comentario = new Comment("Me interesa",usurious);
        comentario.setId(10);
        assertEquals(10,comentario.getId());
    }

    @Test
    void setId() {
        Municipality municipality = new Municipality("testname","testcommune");
        Neighborhood neighborhood = new Neighborhood(municipality, "testname");
        User usurious = new User("testnombre","testpass","testmail", neighborhood);
        Comment comentario = new Comment("Me interesa",usurious);
        comentario.setId(10);
        assertEquals(10,comentario.getId());
    }

    @Test
    void getContent() {
        Municipality municipality = new Municipality("testname","testcommune");
        Neighborhood neighborhood = new Neighborhood(municipality, "testname");
        User usurious = new User("testnombre","testpass","testmail", neighborhood);
        Comment comentario = new Comment("Me interesa",usurious);
        assertEquals("Me interesa",comentario.getContent());
    }

    @Test
    void setContent() {
        Municipality municipality = new Municipality("testname","testcommune");
        Neighborhood neighborhood = new Neighborhood(municipality, "testname");
        User usurious = new User("testnombre","testpass","testmail", neighborhood);
        Comment comentario = new Comment("Me interesa",usurious);
        comentario.setContent("No me interesa");
        assertEquals("No me interesa",comentario.getContent());
    }

    @Test
    void getUser() {
        Municipality municipality = new Municipality("testname","testcommune");
        Neighborhood neighborhood = new Neighborhood(municipality, "testname");
        User usurious = new User("testnombre","testpass","testmail", neighborhood);
        Comment comentario = new Comment("Me interesa",usurious);
        assertEquals(usurious,comentario.getUser());

    }

    @Test
    void setUser() {
        Municipality municipality = new Municipality("testname","testcommune");
        Neighborhood neighborhood = new Neighborhood(municipality, "testname");
        User usurious = new User("testnombre","testpass","testmail", neighborhood);
        Comment comentario = new Comment("Me interesa",usurious);
        Municipality municipality2 = new Municipality("testname","testcommune");
        Neighborhood neighborhood2 = new Neighborhood(municipality, "testname");
        User usurious2 = new User("testnombre","testpass","testmail", neighborhood);
        comentario.setUser(usurious2);
        assertEquals(usurious2,comentario.getUser());
    }

    @Test
    void getTimestamp() {
        Municipality municipality = new Municipality("testname","testcommune");
        Neighborhood neighborhood = new Neighborhood(municipality, "testname");
        User usurious = new User("testnombre","testpass","testmail", neighborhood);
        Comment comentario = new Comment("Me interesa",usurious);
        assertNotNull(comentario.getTimestamp());
    }

    @Test
    void setTimestamp() {
        Municipality municipality = new Municipality("testname","testcommune");
        Neighborhood neighborhood = new Neighborhood(municipality, "testname");
        User usurious = new User("testnombre","testpass","testmail", neighborhood);
        Comment comentario = new Comment("Me interesa",usurious);
        Date now = Date.from(Instant.now());
        comentario.setTimestamp(now);
        assertNotNull(comentario.getTimestamp());
    }
}