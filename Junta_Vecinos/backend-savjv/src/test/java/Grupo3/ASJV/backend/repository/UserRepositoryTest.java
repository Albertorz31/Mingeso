package Grupo3.ASJV.backend.repository;

import Grupo3.ASJV.backend.controller.UserController;
import Grupo3.ASJV.backend.model.Municipality;
import Grupo3.ASJV.backend.model.Neighborhood;
import Grupo3.ASJV.backend.model.User;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;


import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration
@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserController userController;

    @Test
    void findByUsername() {

    }

    @Test
    void existsByUsername() {
        /*
        Municipality municipality = new Municipality("testname","testcommune");
        Neighborhood neighborhood = new Neighborhood(municipality, "testname");
        User usurious = new User("testnombre","testpass","testmail",neighborhood);
        userController.createUser(usurious);
        boolean existe = userRepository.existsByUsername("testnombre");
        assertTrue(existe);

         */
    }

    @Test
    void existsByMail() {
        /*
        User aux = userRepository.findAll().get(0);
        String mail = aux.getMail();
        boolean exist = userRepository.existsByMail(mail);
        assertTrue(exist);

         */
    }
}