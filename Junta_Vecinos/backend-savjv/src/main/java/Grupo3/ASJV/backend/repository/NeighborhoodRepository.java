package Grupo3.ASJV.backend.repository;

import Grupo3.ASJV.backend.model.Neighborhood;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
@Repository
public interface NeighborhoodRepository extends MongoRepository<Neighborhood, Serializable> {
    public Neighborhood findByName(String name);

}
