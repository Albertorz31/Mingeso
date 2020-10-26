import mingeso.cibackend.model.Career;
import mingeso.cibackend.model.Student;
import mingeso.cibackend.repository.CareerRepository;
import mingeso.cibackend.repository.StudentRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static junit.framework.Assert.assertNotNull;
import static org.mockito.BDDMockito.*;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import static junit.framework.TestCase.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TestStudentRepository {

    @Mock
    CareerRepository careerRepository;

    @Mock
    StudentRepository studentRepository;

    @Test
    public void TestNewStudent() throws ParseException {

        System.out.println("*** Student test ***");
        //Se crea un nuevo alumno y se guarda en el repositorio
        Student newStudent = new Student();
        newStudent.setId(1);
        newStudent.setName("Estudiante de Prueba");
        newStudent.setRut("00000000-1");
        newStudent.setBirthdate(new SimpleDateFormat("yyyy-MM-dd").parse("1900-00-01"));

        assertNotNull(newStudent);
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) {
        System.out.println("Finished..." + testInfo.getDisplayName());
    }
}
