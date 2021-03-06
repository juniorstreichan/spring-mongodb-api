package com.juniorstreichan.mongoapitest.config;

import com.juniorstreichan.mongoapitest.domain.Post;
import com.juniorstreichan.mongoapitest.domain.User;
import com.juniorstreichan.mongoapitest.dto.AuthorDTO;
import com.juniorstreichan.mongoapitest.dto.CommentDTO;
import com.juniorstreichan.mongoapitest.repositories.PostRepository;
import com.juniorstreichan.mongoapitest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;


@Configuration(value = "test")
public class Instantiation implements CommandLineRunner {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;


    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();


        User ze = new User("José fino", "jo@ze.com");
        User mano = new User("Mano brau", "brau@racionais.com");
        User ronald = new User("ronaldinho", "ronaldinho@padoc.com");

        userRepository.saveAll(Arrays.asList(
                ze,
                mano,
                ronald
        ));


        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Post post1 = new Post(
                null,
                LocalDate.parse("21/03/2018", dateFormat),
                "Partiu Viagem",
                "Viajando para testelândia",
                new AuthorDTO(ze)
        );


        Post post2 = new Post(
                null,
                LocalDate.parse("23/03/2018", dateFormat),
                "Bom diaaaa",
                "Acordei para teste",
                new AuthorDTO(ze)
        );



        post1.getComments().addAll(Arrays.asList(
                new CommentDTO(
                        "To nem ai",
                        LocalDate.parse("21/03/2018", dateFormat),
                        new AuthorDTO(mano)),
                new CommentDTO(
                        "traz muamba pra mim !!",
                        LocalDate.parse("22/03/2018", dateFormat),
                        new AuthorDTO(ronald))
        ));


        post2.getComments().addAll(Arrays.asList(
                new CommentDTO(
                        "Eita!",
                        LocalDate.parse("21/03/2018", dateFormat),
                        new AuthorDTO(mano))
        ));

        postRepository.saveAll(Arrays.asList(
                post1,
                post2
        ));
        ze.getPosts().addAll(Arrays.asList(post1, post2));

        userRepository.save(ze);

    }
}
