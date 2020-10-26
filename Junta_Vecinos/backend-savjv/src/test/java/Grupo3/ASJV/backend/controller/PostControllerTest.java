package Grupo3.ASJV.backend.controller;

import Grupo3.ASJV.backend.model.Post;
import Grupo3.ASJV.backend.model.User;
import Grupo3.ASJV.backend.repository.PostRepository;
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
class PostControllerTest {

    @Autowired
    PostController postController;

    @Autowired
    PostRepository postRepository;

    @Test
    void getAllPosts() {

        ResponseEntity<List<Post>> p = postController.getAllPosts();
        ResponseEntity<List<Post>> pp = postController.getAllPosts();
        List<Post> post1 = p.getBody();
        List<Post> post2 = pp.getBody();
        assertEquals(post1.size(),post2.size());


    }

    @Test
    void getPostById() {

        ResponseEntity<List<Post>> post = postController.getAllPosts();
        List<Post> postTest = post.getBody();
        ObjectId primerid = new ObjectId();
        primerid = postTest.get(0).getId();
        ResponseEntity<Post> postTest1 = postController.getPostById(primerid);
        Post postTest2 = postTest1.getBody();
        assertEquals(primerid, postTest2.getId());


    }

    @Test
    void createPost() {

        HashMap<String, String> map = new HashMap<>();
        map.put("title", "titulotest");
        map.put("description", "descripciontest");
        ResponseEntity <Post> p = postController.createPost(map);
        assertNotNull(p);


    }

    @Test
    void update() throws ParseException {
        Post aux = postRepository.findAll().get(0);
        HashMap<String,String> map = new HashMap<>();
        map.put("title", "tituloTest");
        map.put("description","descripciontest");
        Post test = postController.update(aux.getId() , map);
        assertEquals("tituloTest",test.getTitle());
        assertEquals("descripciontest",test.getDescription());
    }

    @Test
    void delete() {

        User usurious = new User("testnombre","testpass","testmail");
        Date horaactual = Date.from(Instant.now());
        Post posteo = new Post("titulotest","descripciontest",usurious,"categorytest",horaactual,"pricetest");
        ObjectId primerid = new ObjectId();
        posteo.setId(primerid);
        boolean test = postController.delete(primerid);
        assertEquals(true,test);


    }
}

