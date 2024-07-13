package com.workshopmongodb.dto;

import com.workshopmongodb.domain.User;
import lombok.*;

import java.io.Serializable;
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class AuthorDTO implements Serializable {
    private static final long serialVeriosUID = 1L;

    private String id;
    private String name;

    public AuthorDTO (User user) {
        id = user.getId();
        name = user.getName();
    }
}
