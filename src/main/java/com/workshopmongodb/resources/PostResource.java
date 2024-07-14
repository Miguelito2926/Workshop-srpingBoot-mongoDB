package com.workshopmongodb.resources;

import com.workshopmongodb.domain.Post;
import com.workshopmongodb.resources.util.URLDecode;
import com.workshopmongodb.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URLDecode.decodeParam(text);
        List<Post> post = postService.findByTitle(text);
        return ResponseEntity.ok().body(post);
    }
}

