package com.workshopmongodb.domain;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@Entity
public class Post implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private Date date;
    private String title;
    private String body;

    private User author;

    public Post(String id, Date date, String title, String body, User author) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
    }
}
