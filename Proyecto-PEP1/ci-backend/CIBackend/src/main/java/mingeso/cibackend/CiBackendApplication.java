package mingeso.cibackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class CiBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CiBackendApplication.class, args);
	}

}
