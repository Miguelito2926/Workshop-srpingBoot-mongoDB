package com.workshopmongodb.resources;

import com.workshopmongodb.domain.Post;
import com.workshopmongodb.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Post>> findByPost(@PathVariable String id) {
        Optional<Post> post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }
}

