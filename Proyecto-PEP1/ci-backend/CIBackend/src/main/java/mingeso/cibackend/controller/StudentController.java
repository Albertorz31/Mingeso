package mingeso.cibackend.controller;

import mingeso.cibackend.model.Career;
import mingeso.cibackend.model.Student;
import mingeso.cibackend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping(path = "/student")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("")
    public ResponseEntity<List<Student>> getAllStudents(){
        try{
            List<Student> students = new ArrayList<Student>();
            studentRepository.findAll().forEach(students::add);
            if (students.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(students, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Integer id){
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return new ResponseEntity<>(student.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        try {
            System.out.println(student.getName());
            System.out.println(student.getRut());
            System.out.println(student.getBirthdate());
            System.out.println("Career: ");
            System.out.println(student.getCareer().getName());

            Student newStudent = new Student(student.getName(), student.getRut(), student.getBirthdate(), student.getCareer());

            Student _student = studentRepository.save(newStudent);
            return new ResponseEntity<>(_student, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable String id, @RequestBody Map<String, String> body) throws ParseException {
        int alumnoId = Integer.parseInt(id);
        //getting Student
        Student student = studentRepository.getOne(alumnoId);
        student.setName(body.get("name"));
        student.setRut(body.get("rut"));
        student.setBirthdate(new SimpleDateFormat("yyyy-MM-dd").parse(body.get("birthdate")));
        return studentRepository.save(student);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable String id){
        int studentId = Integer.parseInt(id);
        studentRepository.deleteById(studentId);
        return true;
    }

}
