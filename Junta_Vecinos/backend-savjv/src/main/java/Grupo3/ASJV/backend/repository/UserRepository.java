package Grupo3.ASJV.backend.repository;

import Grupo3.ASJV.backend.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
@Repository
public interface UserRepository extends MongoRepository<User, Serializable> {
    public User findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByMail(String mail);
}