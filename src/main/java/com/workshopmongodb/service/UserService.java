package com.workshopmongodb.service;

import com.workshopmongodb.domain.User;
import com.workshopmongodb.domain.repository.UserRepository;
import com.workshopmongodb.dto.UserDTO;
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

    public User insertUser(User user) {
        return userRepository.insert(user);
    }

    public void deleteById(String id) {
        findById(id);
        userRepository.deleteById(id);
    }

    public Optional<User> update(User user) {
         Optional<User> newUser = userRepository.findById(user.getId());
         if (newUser.isPresent()){
            User userExisting = newUser.get();
            updateData(userExisting, user);
             User updateUser = userRepository.save(userExisting);
            return Optional.of(updateUser);
         }else {
             return Optional.empty();
         }

    }

    private void updateData(User userExisting, User user) {
        userExisting.setName(user.getName());
        userExisting.setEmail(user.getEmail());
    }


    public User fromDTO(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}
