package com.workshopmongodb.resources;

import com.workshopmongodb.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping

       public ResponseEntity<List<User>> findAll() {
            User miguel = new User("1", "Miguel", "miguel@gamil.com");
            User junior = new User("2", "junior", "junior@gamil.com");

            List<User> list = new ArrayList<>();
            list.addAll(Arrays.asList(miguel, junior));

            return ResponseEntity.ok().body(list);
        }
    }

