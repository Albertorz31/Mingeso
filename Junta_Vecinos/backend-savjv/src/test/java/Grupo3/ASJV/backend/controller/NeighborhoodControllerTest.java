package Grupo3.ASJV.backend.controller;
import Grupo3.ASJV.backend.model.Neighborhood;
import Grupo3.ASJV.backend.model.Municipality;
import Grupo3.ASJV.backend.repository.NeighborhoodRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.http.ResponseEntity;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ContextConfiguration
@SpringBootTest
class NeighborhoodControllerTest {

    @Autowired
    NeighborhoodController neighborhoodController;
    @Autowired
    NeighborhoodRepository neighborhoodRepository;

    @Test
    void getAllNeighborhoods() {

        ResponseEntity<List<Neighborhood>> neighborhood1 = neighborhoodController.getAllNeighborhoods();
        ResponseEntity<List<Neighborhood>> neighborhood2 = neighborhoodController.getAllNeighborhoods();
        List<Neighborhood> NeighborhoodTest1 = neighborhood1.getBody();
        List<Neighborhood> NeighborhoodTest2 = neighborhood2.getBody();
        assertEquals(NeighborhoodTest1.size(),NeighborhoodTest2.size());
    }

    @Test
    void getNeighborhood() {
        /*
        Municipality municipality = new Municipality("testname","testcommune");
        Neighborhood neighborhood = new Neighborhood(municipality, "testname");
        neighborhood.setId(1000);
        ResponseEntity<Neighborhood> neighborhood1 = neighborhoodController.getNeighborhood("1000");
        Neighborhood neighborhood2 = neighborhood1.getBody();
        assertEquals(1000, neighborhood2.getId());

         */

    }

    @Test
    void createNeighborhood() {

        HashMap<String, String> map = new HashMap<>();
        map.put("municipality_id", "0");
        ResponseEntity <Neighborhood> neighborhooduno = neighborhoodController.createNeighborhood(map);
        assertNotNull(neighborhooduno);

    }
    @Test
    void update() throws ParseException {
        Neighborhood aux = neighborhoodRepository.findAll().get(0);
        String idAux = Long.toString(aux.getId());
        Municipality municipality = new Municipality("PuenteAlto","testcommune");
        String IdMuni =  Long.toString(municipality.getId());
        HashMap<String, String> map = new HashMap<>();
        map.put("municipality", IdMuni);
        map.put("name", "Cristobal");
        Neighborhood test = neighborhoodController.update(idAux, map);
        String name = test.getName();
        assertEquals("Cristobal",name);
    }

    @Test
    void delete() {

        Municipality municipality = new Municipality("testname","testcommune");
        Neighborhood neighborhood = new Neighborhood(municipality, "testname");
        neighborhood.setId(1000);
        boolean test = neighborhoodController.delete("1000");
        assertEquals(true,test);


    }

}