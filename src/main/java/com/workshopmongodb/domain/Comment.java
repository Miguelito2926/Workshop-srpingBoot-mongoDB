package com.workshopmongodb.domain;

import jakarta.persistence.Entity;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;
@NoArgsConstructor
@Data
@Builder
@Getter
@Setter
@Entity
public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String text;
    private Instant date;

    public Comment(String id, String text, Instant date) {
        this.id = id;
        this.text = text;
        this.date = date;
    }
}
