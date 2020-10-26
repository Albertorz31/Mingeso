import mingeso.cibackend.repository.CareerRepository;
import mingeso.cibackend.repository.StudentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.Assert.*;

@ExtendWith(MockitoExtension.class)
public class TestRepositories {

    @Mock
    CareerRepository careerRepository;
    @Mock
    StudentRepository studentRepository;

    @Test
    public void TestCareer(){
        assertNotNull(careerRepository);
        assertNotNull(studentRepository);
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) {
        System.out.println("Finished..." + testInfo.getDisplayName());
    }
}
