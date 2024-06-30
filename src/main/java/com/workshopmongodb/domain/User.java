package com.workshopmongodb.domain;



import jakarta.persistence.Entity;

import lombok.*;

import java.io.Serializable;
@Builder
@NoArgsConstructor
@Data
@Entity
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String email;

    public User (String  id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

}
