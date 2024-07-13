package com.workshopmongodb.service;

import com.workshopmongodb.domain.Post;
import com.workshopmongodb.domain.repository.PostRepository;
import com.workshopmongodb.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> findAll(){
        return postRepository.findAll();
    }

    public Optional<Post> findById(String id) {
        Optional<Post> post = postRepository.findById(id);
        if(!postRepository.existsById(id)){
            throw new ObjectNotFoundException("User Not found: " + id);
        }
        return post;
    }
}
