package com.workshopmongodb.resources.config;

import com.workshopmongodb.domain.Post;
import com.workshopmongodb.domain.User;
import com.workshopmongodb.domain.repository.PostRepository;
import com.workshopmongodb.domain.repository.UserRepository;
import com.workshopmongodb.dto.AuthorDTO;
import com.workshopmongodb.dto.CommentDTO;
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
        User dione = new User(null, "Nica Tavares", "nica@gamil.com");

        userRepository.saveAll(Arrays.asList(dione, ednaldo, miguel));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
    Post post = new Post(null,sdf.parse(
            "13/07/2024"),"Partiu Viagem!",
            "Vou viajar para São Paulo. Abraços!", new AuthorDTO(miguel));

        Post post1 = new Post(null,sdf.parse(
                "13/07/2024"),"Bom dia!",
                "Acordei feliz hoje!!", new AuthorDTO(miguel));

         CommentDTO comment = new CommentDTO("Boa viagem mano!", sdf.parse("14/07/2024"), new AuthorDTO(ednaldo));
         CommentDTO comment1 = new CommentDTO("Aproveite!", sdf.parse("14/07/2024"), new AuthorDTO(ednaldo));
         CommentDTO comment2 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("14/07/2024"), new AuthorDTO(miguel));

         post.getComments().addAll(Arrays.asList(comment,comment1));
         post1.getComments().addAll(Arrays.asList(comment2));
         postRepository.saveAll(Arrays.asList(post, post1));

        miguel.getPosts().addAll(Arrays.asList(post, post1));
        userRepository.save(miguel);

    }

}
