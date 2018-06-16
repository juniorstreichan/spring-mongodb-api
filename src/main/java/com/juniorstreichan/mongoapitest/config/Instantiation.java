package com.juniorstreichan.mongoapitest.config;

import com.juniorstreichan.mongoapitest.domain.User;
import com.juniorstreichan.mongoapitest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;


@Configuration
public class Instantiation implements CommandLineRunner {


    @Autowired
    private UserRepository repository;


    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();

        repository.saveAll(Arrays.asList(
                new User("José fino", "jo@ze.com"),
                new User("Mano brau", "brau@racionais.com"),
                new User("ronaldinho", "ronaldinho@padoc.com")
        ));
    }
}
