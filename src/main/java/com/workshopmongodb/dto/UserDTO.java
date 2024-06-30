package com.workshopmongodb.dto;

import com.workshopmongodb.domain.User;
import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor

public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String email;

    public UserDTO(User user) {

        name = user.getName();
        email = user.getEmail();
    }
}
