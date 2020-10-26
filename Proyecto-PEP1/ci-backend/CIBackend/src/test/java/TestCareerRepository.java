import mingeso.cibackend.model.Career;
import mingeso.cibackend.repository.CareerRepository;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInfo;

import java.util.Collections;

import static junit.framework.Assert.assertNotNull;
import static org.mockito.BDDMockito.*;

import static org.junit.Assert.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TestCareerRepository {

    @Mock
    CareerRepository careerRepository;

    @Test
    public void TestNewCarrer(){
        //Se crea una nueva carrera
        Career newCareer = new Career();
        newCareer.setName("Ingeniería Civil Informática");
        newCareer.setCod("fra-3454");

        assertNotNull(newCareer);
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) {
        System.out.println("Finished..." + testInfo.getDisplayName());
    }
}
