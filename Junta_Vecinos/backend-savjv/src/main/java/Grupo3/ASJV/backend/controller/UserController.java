package Grupo3.ASJV.backend.controller;


import Grupo3.ASJV.backend.model.Neighborhood;
import Grupo3.ASJV.backend.model.User;
import Grupo3.ASJV.backend.repository.NeighborhoodRepository;
import Grupo3.ASJV.backend.repository.UserRepository;
import Grupo3.ASJV.backend.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    NeighborhoodRepository neighborhoodRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers(){
        try{
            List<User> user = new ArrayList<User>();
            userRepository.findAll().forEach(user::add);
            if(user.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") long id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<User> createUser(@RequestBody Map<String, String> body){
        try{
            Long neighborhoodId = Long.parseLong(body.get("neighborhood_id"));
            Neighborhood neighborhood = neighborhoodRepository.findById(neighborhoodId).get();

            User newUser = new User(body.get("username"), body.get("password"), body.get("mail"), neighborhood);
            newUser.setId(sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME));
            User user1 = userRepository.save(newUser);
            return new ResponseEntity<>(user1, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/{id}")
    public User update(@PathVariable String id, @RequestBody Map<String, String> body) throws ParseException{
        Long userId = Long.parseLong(id);
        User user = userRepository.findById(userId).get();
        user.setUsername(body.get("username"));
        user.setPassword(body.get("password"));
        user.setMail(body.get("mail"));
        return userRepository.save(user);
    }

    @DeleteMapping("{/id}")
    public boolean delete(@PathVariable String id){
        long userId = Long.parseLong(id);
        userRepository.deleteById(userId);
        return true;
    }
}
