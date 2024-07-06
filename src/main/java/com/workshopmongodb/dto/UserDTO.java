package com.workshopmongodb.dto;

import com.workshopmongodb.domain.User;
import lombok.*;

import java.io.Serializable;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor

public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private String email;

    public UserDTO(User user) {
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
    }
//Construtor ja é inatnciado recebendo os dados automaticamnente sem a necessidade de setar
    public UserDTO(Optional<User> user) {
        this.id = user.get().getId();
        name = user.get().getName();
        email = user.get().getEmail();
    }
}
