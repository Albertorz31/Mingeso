package Grupo3.ASJV.backend.controller;


import Grupo3.ASJV.backend.model.Post;
import Grupo3.ASJV.backend.model.User;
import Grupo3.ASJV.backend.model.Comment;
import Grupo3.ASJV.backend.repository.PostRepository;
import Grupo3.ASJV.backend.repository.UserRepository;
import Grupo3.ASJV.backend.repository.CommentRepository;
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
@RequestMapping(path = "/post/comments")
public class CommentController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;


    @GetMapping("/{post_id}")
    public ResponseEntity<List<Comment>> getCommentsByPost(@PathVariable("post_id") ObjectId post_id){
        Optional<Post> post = postRepository.findById(post_id);
        if(post.isPresent()){
            Post nonOpPost = post.get();
            return new ResponseEntity<>(nonOpPost.getComments(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{post_id}")
    public ResponseEntity<Post> createComment(@PathVariable("post_id") ObjectId post_id,@RequestBody Map<String, String> body){
        try{
            //User assignment
            Long userId = Long.parseLong(body.get("user_id"));
            User user = userRepository.findById(userId).get();
            System.out.println("Usuario encontrado: "+ user.getUsername());

            //Post assignment
            System.out.println("Post_id: " + post_id);
            Optional<Post> OpPost = postRepository.findById(post_id);
            System.out.println("OpPost encontrado");
            Post post = OpPost.get();
                System.out.println("Post encontrado: " + post.getTitle());

            Comment newComment = new Comment(body.get("content"), user);
            System.out.println("Comentario: " + newComment.getContent());

            newComment.setId(sequenceGeneratorService.generateSequence(Comment.SEQUENCE_NAME));
            Comment comment = commentRepository.save(newComment);

            //Asignar comentario a post
            post.addComment(newComment);
            postRepository.save(post);
            System.out.println("Post_id: " + post.getId());
            System.out.println("Post title: " + post.getTitle());

            System.out.println("OK");
            return new ResponseEntity<>(post, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    /*
    @PutMapping("/{id}")
    public Post update(@PathVariable String id, @RequestBody Map<String, String> body) throws ParseException{
        Long postId = Long.parseLong(id);
        Post post = postRepository.findById(postId).get();
        post.setTitle(body.get("title"));
        post.setDescription(body.get("description"));
        post.setCategory(body.get("category"));
        post.setPrice(body.get("price"));
        return post;
    }

    @DeleteMapping("{/id}")
    public boolean delete(@PathVariable String id){
        long postId = Long.parseLong(id);
        postRepository.deleteById(postId);
        return true;
    }
    */
}
