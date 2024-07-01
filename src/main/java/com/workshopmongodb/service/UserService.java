package com.workshopmongodb.service;

import com.workshopmongodb.domain.User;
import com.workshopmongodb.domain.repository.UserRepository;
import com.workshopmongodb.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(String id) {
        Optional<User> user = userRepository.findById(id);
        if(!userRepository.existsById(id)){
            throw new ObjectNotFoundException("User Not found: " + id);
        }
        return user;
    }
}
