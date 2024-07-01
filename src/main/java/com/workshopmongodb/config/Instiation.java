package com.workshopmongodb.config;

import com.workshopmongodb.domain.User;
import com.workshopmongodb.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class Instiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
/*
        User ednaldo = new User(null, "Ednaldo Tavares", "ednaldo@gamil.com");
        User miguel = new User(null, "Miguel Tavares", "miguel@gamil.com");
        User nica = new User(null, "Nica Tavares", "nica@gamil.com");*/
/*
        userRepository.saveAll(Arrays.asList(nica, ednaldo, miguel));*/
    }
}
