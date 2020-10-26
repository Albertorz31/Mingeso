package mingeso.cibackend.controller;

import mingeso.cibackend.model.Career;
import mingeso.cibackend.model.Student;
import mingeso.cibackend.repository.CareerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/career")
@CrossOrigin(origins = "*")
public class CareerController {

    @Autowired
    CareerRepository careerRepository;

    @GetMapping("")
    public ResponseEntity<List<Career>> getAllCareers(){
        try{
            List<Career> careers = new ArrayList<>();
            careerRepository.findAll().forEach(careers::add);
            if (careers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(careers, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Career> getCareerById(@PathVariable("id") Integer id){
        Optional<Career> career = careerRepository.findById(id);
        if (career.isPresent()) {
            return new ResponseEntity<>(career.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<Career> createCareer(@RequestBody Career career){
        try {
            Career _career = careerRepository
                    .save(new Career(career.getCod(), career.getName()));
            return new ResponseEntity<>(_career, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/{id}")
    public Career update(@PathVariable String id, @RequestBody Map<String, String> body){
        int careerId = Integer.parseInt(id);
        //getting Career
        Career career = careerRepository.getOne(careerId);
        career.setCod(body.get("cod"));
        career.setName(body.get("name"));
        return careerRepository.save(career);
    }


    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable String id){
        int careerId = Integer.parseInt(id);
        careerRepository.deleteById(careerId);
        return true;
    }

}
