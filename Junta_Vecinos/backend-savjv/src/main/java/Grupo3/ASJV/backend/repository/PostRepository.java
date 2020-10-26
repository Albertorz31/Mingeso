package Grupo3.ASJV.backend.repository;

import Grupo3.ASJV.backend.model.Post;
import Grupo3.ASJV.backend.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, ObjectId>{
}
