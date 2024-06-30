package com.workshopmongodb.domain;



import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
@Builder
@NoArgsConstructor
@Data

@Document(collection = "user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String name;
    private String email;

    public User (String  id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

}
