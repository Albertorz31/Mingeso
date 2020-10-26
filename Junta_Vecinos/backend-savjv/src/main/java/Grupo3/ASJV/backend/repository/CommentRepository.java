package Grupo3.ASJV.backend.repository;

import Grupo3.ASJV.backend.model.Comment;
import Grupo3.ASJV.backend.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommentRepository extends MongoRepository<Comment, Long>{
}
