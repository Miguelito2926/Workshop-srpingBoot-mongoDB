package com.workshopmongodb.dto;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

public class CommentDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String text;
    private Date date;
    private AuthorDTO author;
}