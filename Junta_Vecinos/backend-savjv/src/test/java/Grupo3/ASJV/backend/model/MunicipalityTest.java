package Grupo3.ASJV.backend.model;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class MunicipalityTest {

    @Test
    void getId() {
        Municipality municipality = new Municipality("testname","testcommune");
        municipality.setId(10101);
        assertEquals(10101,(long)municipality.getId());
    }

    @Test
    void setId() {
        Municipality municipality = new Municipality("testname","testcommune");
        municipality.setId(10101);
        assertEquals(10101,(long)municipality.getId());
    }

    @Test
    void getName() {
        Municipality municipality = new Municipality("testname","testcommune");
        assertEquals("testname", municipality.getName());
    }

    @Test
    void setName() {
        Municipality municipality = new Municipality("testname","testcommune");
        municipality.setName("testnombre");
        assertEquals("testnombre", municipality.getName());
    }

    @Test
    void getCommune() {
        Municipality municipality = new Municipality("testname","testcomune");
        assertEquals("testcomune", municipality.getCommune());
    }

    @Test
    void setCommune() {
        Municipality municipality = new Municipality("testname","testcommune");
        municipality.setCommune("testcomuna");
        assertEquals("testcomuna", municipality.getCommune());
    }
}