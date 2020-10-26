package Grupo3.ASJV.backend.controller;

import Grupo3.ASJV.backend.model.*;
import Grupo3.ASJV.backend.repository.UserRepository;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;


import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ContextConfiguration
@SpringBootTest
class CommentControllerTest {


    @Autowired
    PostController postController;
    @Autowired
    CommentController commentController;

    @Test
    void getCommentsByPost() {
        ResponseEntity<List<Post>> post = postController.getAllPosts();
        List<Post> postTest = post.getBody();
        ObjectId primerid = new ObjectId();
        primerid = postTest.get(0).getId();
        ResponseEntity<Post> postTest1 = postController.getPostById(primerid);
        Post postTest2 = postTest1.getBody();
        ObjectId segundoid =postTest2.getId();
        ResponseEntity<List<Comment>> c = commentController.getCommentsByPost(segundoid);
        assertNotNull(c);
    }

    @Test
    void createComment() {
        Municipality municipality = new Municipality("testname","testcommune");
        Neighborhood neighborhood = new Neighborhood(municipality, "testname");
        User usurious = new User("testnombre","testpass","testmail", neighborhood);
        Comment comentario = new Comment("Me interesa",usurious);
        ObjectId IddelPost = new ObjectId();
        HashMap<String, String> map = new HashMap<>();
        map.put("title", "titulotest");
        map.put("description", "descripciontest");
        ResponseEntity<Post> c = commentController.createComment(IddelPost,map);
        assertNotNull(c);
        assertEquals(0,comentario.getId());
    }
}