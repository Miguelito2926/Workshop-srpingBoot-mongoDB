package com.workshopmongodb.domain;

import jakarta.persistence.Entity;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;
@Data
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Post implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private Instant date;
    private String title;
    private String body;

    public Post(String id, Instant date, String title, String body) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
    }
}
