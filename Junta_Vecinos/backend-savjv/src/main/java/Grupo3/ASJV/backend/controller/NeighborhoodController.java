package Grupo3.ASJV.backend.controller;


import Grupo3.ASJV.backend.model.Municipality;
import Grupo3.ASJV.backend.model.Neighborhood;
import Grupo3.ASJV.backend.repository.MunicipalityRepository;
import Grupo3.ASJV.backend.repository.NeighborhoodRepository;
import Grupo3.ASJV.backend.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/neighborhood")
public class NeighborhoodController{

    @Autowired
    NeighborhoodRepository neighborhoodRepository;

    @Autowired
    MunicipalityRepository municipalityRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @GetMapping("")
    public ResponseEntity<List<Neighborhood>> getAllNeighborhoods(){
        try {
            List<Neighborhood> neighborhood = new ArrayList<Neighborhood>();
            neighborhoodRepository.findAll().forEach(neighborhood::add);
            if(neighborhood.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(neighborhood,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Neighborhood> getNeighborhood(@PathVariable("id") String id){
        Optional<Neighborhood> neighborhood = neighborhoodRepository.findById(id);
        if(neighborhood.isPresent()){
            return new ResponseEntity<>(neighborhood.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<Neighborhood> createNeighborhood(@RequestBody Map<String, String> body){
        try{
            //Municipality assignment
            Long municipalityId = Long.parseLong(body.get("municipality_id"));
            Municipality municipality = municipalityRepository.findById(municipalityId).get();

            Neighborhood newNeighborhood = new Neighborhood(municipality,body.get("name"));
            newNeighborhood.setId(sequenceGeneratorService.generateSequence(Neighborhood.SEQUENCE_NAME));
            Neighborhood neighborhood1 = neighborhoodRepository.save(newNeighborhood);
            return new ResponseEntity<>(neighborhood1, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/{id}")
    public Neighborhood update(@PathVariable String id, @RequestBody Map<String, String> body) throws ParseException{
        Long neighborhoodId = Long.parseLong(id);
        Neighborhood neighborhood = neighborhoodRepository.findById(neighborhoodId).get();
        neighborhood.setName(body.get("name"));
        return  neighborhood;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable String id){
        long neighborhoodId = Long.parseLong(id);
        neighborhoodRepository.deleteById(neighborhoodId);
        return true;
    }

}
