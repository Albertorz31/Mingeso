package Grupo3.ASJV.backend.repository;

import Grupo3.ASJV.backend.model.Municipality;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface MunicipalityRepository extends MongoRepository<Municipality, Long> {
}
