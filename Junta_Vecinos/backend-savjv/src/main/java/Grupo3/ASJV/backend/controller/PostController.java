package Grupo3.ASJV.backend.controller;


import Grupo3.ASJV.backend.model.Post;
import Grupo3.ASJV.backend.model.User;
import Grupo3.ASJV.backend.repository.PostRepository;
import Grupo3.ASJV.backend.repository.UserRepository;
import Grupo3.ASJV.backend.service.SequenceGeneratorService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.Instant;
import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/post")
public class PostController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @GetMapping("")
    public ResponseEntity<List<Post>> getAllPosts(){
        try{
            System.out.println("Buscando posts...");
            List<Post> posts = new ArrayList<Post>();
            System.out.println("Ok 1");
            postRepository.findAll().forEach(posts::add);
            System.out.println("Ok 2");
            if(posts.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            System.out.println("Ok 3");
            return new ResponseEntity<>(posts, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable("id") ObjectId id){
        Optional<Post> post = postRepository.findById(id);
        if(post.isPresent()){
            return new ResponseEntity<>(post.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<Post> createPost(@RequestBody Map<String, String> body){
        try{
            //User assignment
            Long userId = Long.parseLong(body.get("user_id"));
            User user = userRepository.findById(userId).get();

            //Time assigment
            Date now = Date.from(Instant.now());
            System.out.println("New post: "+ now);

            Post newPost = new Post(body.get("title"), body.get("description"),
                    user,body.get("category"), now,body.get("price"));
            //Sin setear Id
            //newPost.setId();
            Post post1 = postRepository.save(newPost);
            return new ResponseEntity<>(post1, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/{id}")
    public Post update(@PathVariable ObjectId _id, @RequestBody Map<String, String> body) throws ParseException{
        Post post = postRepository.findById(_id).get();
        post.setTitle(body.get("title"));
        post.setDescription(body.get("description"));
        post.setCategory(body.get("category"));
        post.setPrice(body.get("price"));
        return post;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") ObjectId _id){
        postRepository.deleteById(_id);
        return true;
    }
}
