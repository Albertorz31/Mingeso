package Grupo3.ASJV.backend.repository;

import Grupo3.ASJV.backend.model.Erole;
import Grupo3.ASJV.backend.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.io.Serializable;
import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, Serializable> {
    Optional<Role> findByName(Erole name);
}
