package mingeso.cibackend.repository;

import mingeso.cibackend.model.Career;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CareerRepository extends JpaRepository<Career, Integer>{
    //Custom querys
     Career findCareerById(Integer id);
     Career findCareerByName(String name);
}
