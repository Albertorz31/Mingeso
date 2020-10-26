package Grupo3.ASJV.backend.controller;

import Grupo3.ASJV.backend.model.Municipality;
import Grupo3.ASJV.backend.model.Neighborhood;
import Grupo3.ASJV.backend.model.Post;
import Grupo3.ASJV.backend.model.User;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import Grupo3.ASJV.backend.repository.UserRepository;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration
@SpringBootTest
class UserControllerTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserController userController;


    @Test
    void getAllUsers(){
        ResponseEntity<List<User>> user1 = userController.getAllUsers();
        ResponseEntity<List<User>> user2 = userController.getAllUsers();
        List<User> userTest1 = user1.getBody();
        List<User> userTest2 = user2.getBody();
        assertEquals(userTest1.size(),userTest2.size());
        }


    @Test
    void getUserById() {
        ResponseEntity<List<User>> user = userController.getAllUsers();
        List<User> userTest = user.getBody();
        long id = userTest.get(0).getId();
        ResponseEntity<User> user1 = userController.getUserById(id);
        User user2 = user1.getBody();
        assertEquals(id, (long)user2.getId());


    }
    @Test
    void createUser() {

        HashMap<String, String> map = new HashMap<>();
        map.put("username", "Cristobal");
        map.put("password", "cafe1234");
        map.put("mail", "hola@hotmail.com");
        ResponseEntity <User> u = userController.createUser(map);
        assertNotNull(u);
    }

    @Test
    void update()  {

    }

    @Test
    void delete() {

        User usurious = new User("Cristobal","cafe1234","hola@hotmail.com");
        usurious.setId(1000);
        boolean test = userController.delete("1000");
        assertEquals(true,test);


    }
}