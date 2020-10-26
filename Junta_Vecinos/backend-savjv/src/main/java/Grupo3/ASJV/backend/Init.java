package Grupo3.ASJV.backend;

import Grupo3.ASJV.backend.model.Municipality;
import Grupo3.ASJV.backend.model.Neighborhood;
import Grupo3.ASJV.backend.model.Post;
import Grupo3.ASJV.backend.model.User;
import Grupo3.ASJV.backend.repository.PostRepository;
import Grupo3.ASJV.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class Init {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;

    public void init(){
        System.out.println("Iniciando...");
        User admin = new User("admin", "password", "admin@admin");
        userRepository.save(admin);

        //Post post = new Post("Title", "this is a post", admin, )
    }
}
