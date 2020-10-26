package Grupo3.ASJV.backend;

import Grupo3.ASJV.backend.model.Post;
import Grupo3.ASJV.backend.model.Role;
import Grupo3.ASJV.backend.model.User;
import Grupo3.ASJV.backend.repository.PostRepository;
import Grupo3.ASJV.backend.repository.RoleRepository;
import Grupo3.ASJV.backend.repository.UserRepository;
import Grupo3.ASJV.backend.service.SequenceGeneratorService;
import com.sun.source.tree.NewClassTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.time.*;
import java.util.Date;
import java.util.function.DoubleToIntFunction;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	UserRepository userRepository;
	@Autowired
	PostRepository postRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	@EventListener(ApplicationReadyEvent.class)
	public void run(){
		/*
		System.out.println("Deleteando users...");
		userRepository.deleteAll();
		System.out.println("Deleteando posts...");
		postRepository.deleteAll();
		System.out.println("Iniciando...");
		User admin = new User("admin", "password", "admin@admin");
		userRepository.save(admin);
		// Calculating timestamp
		Date now = Date.from(Instant.now());
		System.out.println("Date: "+ now);

		Post post = new Post("title", "This is a description!", admin, now, null);
		postRepository.save(post);
		System.out.println("Post saved");
		*/
	}
}
