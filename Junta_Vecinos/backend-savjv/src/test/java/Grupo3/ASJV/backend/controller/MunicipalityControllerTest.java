package Grupo3.ASJV.backend.controller;

import Grupo3.ASJV.backend.model.*;
import Grupo3.ASJV.backend.repository.MunicipalityRepository;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.time.Instant;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration
@SpringBootTest
class MunicipalityControllerTest {

    @Autowired
    MunicipalityController municipalityController;

    @Autowired
    MunicipalityRepository municipalityRepository;

    @Test
    void getAllMunicipality() {
        ResponseEntity<List<Municipality>> muni1 = municipalityController.getAllMunicipality();
        ResponseEntity<List<Municipality>> muni2 = municipalityController.getAllMunicipality();
        List<Municipality> municipalityList1 = muni1.getBody();
        List<Municipality> municipalityList2 = muni2.getBody();
        assertEquals(municipalityList1.size(),municipalityList2.size());
    }

    @Test
    void getMunicipalityById() {
        ResponseEntity<List<Municipality>> municipality = municipalityController.getAllMunicipality();
        List<Municipality> municipalityList = municipality.getBody();
        Long primerid = municipalityList.get(0).getId();
        ResponseEntity<Municipality> muni = municipalityController.getMunicipalityById(primerid);
        Municipality municipality1 = muni.getBody();
        assertEquals(primerid, municipality1.getId());

    }
    @Test
    void createMunicipality() {
        Municipality municipality1 = new Municipality("PuenteAlto","testcommune");
        ResponseEntity <Municipality> municipality = municipalityController.createMunicipality(municipality1);
        assertNotNull(municipality);
    }

    @Test
    void update() throws ParseException{
        /*
        Municipality aux = municipalityRepository.findAll().get(0);
        String idAux = Long.toString(aux.getId());
        HashMap<String,String> map = new HashMap<>();
        map.put("name", "nombreTest");
        map.put("commune","vitacura");
        Municipality test = municipalityController.update(idAux , map);
        assertEquals("nombreTest",test.getName());
        assertEquals("vitacura",test.getCommune());

         */
    }

    @Test
    void delete() {
        Municipality municipality = new Municipality("testname","testcommune");
        municipality.setId(1000);
        boolean test = municipalityController.delete("1000");
        assertTrue(test);
    }
}