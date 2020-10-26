package mingeso.cibackend.repository;

import mingeso.cibackend.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
    //Custom querys
    Student findStudentById(Integer id);
    Student findStudentByName(String name);
}
