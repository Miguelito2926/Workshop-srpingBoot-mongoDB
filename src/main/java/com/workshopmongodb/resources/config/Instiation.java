package com.workshopmongodb.resources.config;

import com.workshopmongodb.domain.Post;
import com.workshopmongodb.domain.User;
import com.workshopmongodb.domain.repository.PostRepository;
import com.workshopmongodb.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;


@Configuration
public class Instiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;



    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        postRepository.deleteAll();

        User ednaldo = new User(null, "Ednaldo Tavares", "ednaldo@gamil.com");
        User miguel = new User(null, "Miguel Tavares", "miguel@gamil.com");
        User Dione = new User(null, "Nica Tavares", "nica@gamil.com");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
    Post post = new Post(null,sdf.parse(
            "13/07/2024"),"Partiu Viagem!",
            "Vou viajar para São Paulo. Abraços!", Dione);

        Post post1 = new Post(null,sdf.parse(
                "13/07/2024"),"Bom dia!",
                "Acordei feliz hoje!!", miguel);

        userRepository.saveAll(Arrays.asList(Dione, ednaldo, miguel));
        postRepository.saveAll(Arrays.asList(post, post1));

    }

}
