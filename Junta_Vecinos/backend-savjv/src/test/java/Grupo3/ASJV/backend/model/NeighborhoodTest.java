package Grupo3.ASJV.backend.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NeighborhoodTest {

    @Test
    void getId() {
        Municipality municipality = new Municipality("testname","testcommune");
        Neighborhood neighborhood = new Neighborhood(municipality, "testname");
        neighborhood.setId(10101);
        assertEquals(10101,neighborhood.getId());
    }

    @Test
    void setId() {
        Municipality municipality = new Municipality("testname","testcommune");
        Neighborhood neighborhood = new Neighborhood(municipality, "testname");
        neighborhood.setId(10101);
        assertEquals(10101,(long)neighborhood.getId());
    }

    @Test
    void getMunicipality() {
        Municipality municipality = new Municipality("testname","testcommune");
        Neighborhood neighborhood = new Neighborhood(municipality, "testname");
        assertEquals(municipality,neighborhood.getMunicipality());
    }

    @Test
    void setMunicipality() {
        Municipality municipality = new Municipality("testname","testcommune");
        Neighborhood neighborhood = new Neighborhood(municipality, "testname");
        Municipality municipalitydos = new Municipality("testname2","testcommune2");
        neighborhood.setMunicipality(municipalitydos);
        assertEquals(municipalitydos,neighborhood.getMunicipality());
    }

    @Test
    void getName() {
        Municipality municipality = new Municipality("testname","testcommune");
        Neighborhood neighborhood = new Neighborhood(municipality, "testname");
        assertEquals("testname",neighborhood.getName());
    }

    @Test
    void setName() {
        Municipality municipality = new Municipality("testname","testcommune");
        Neighborhood neighborhood = new Neighborhood(municipality, "testname");
        neighborhood.setName("testname2");
        assertEquals("testname2",neighborhood.getName());
    }
}