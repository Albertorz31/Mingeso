package Grupo3.ASJV.backend.controller;


import Grupo3.ASJV.backend.model.Municipality;
import Grupo3.ASJV.backend.repository.MunicipalityRepository;
import Grupo3.ASJV.backend.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/municipality")
public class MunicipalityController {

    @Autowired
    MunicipalityRepository municipalityRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @GetMapping("")
    public ResponseEntity<List<Municipality>> getAllMunicipality(){
        try{
            List<Municipality> municipalities = new ArrayList<Municipality>();
            municipalityRepository.findAll().forEach(municipalities::add);
            if(municipalities.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(municipalities, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Municipality> getMunicipalityById(@PathVariable("id") long id){
        Optional<Municipality> municipality = municipalityRepository.findById(id);
        if(municipality.isPresent()){
            return new ResponseEntity<>(municipality.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<Municipality> createMunicipality(@RequestBody Municipality municipality){
        try {
            Municipality newMunicipality = new Municipality(municipality.getName(),municipality.getCommune());
            newMunicipality.setId(sequenceGeneratorService.generateSequence(Municipality.SEQUENCE_NAME));
            Municipality municipality1 = municipalityRepository.save(newMunicipality);
            return new ResponseEntity<>(municipality1, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/{id}")
    public Municipality update(@PathVariable String id, @RequestBody Map<String, String> body) throws ParseException{
        Long municipalityId = Long.parseLong(id);
        Municipality municipality = municipalityRepository.findById(municipalityId).get();
        municipality.setName(body.get("name"));
        municipality.setCommune(body.get("commune"));
        return municipalityRepository.save(municipality);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable String id){
        long municipalityId = Long.parseLong(id);
        municipalityRepository.deleteById(municipalityId);
        return true;
    }

}
