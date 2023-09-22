package com.DevIsh.blogWeb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comments")
public class Comment {
    @Id
    private int comment_id ;
    private int blog_id ;
    private int commenter_id ;
    private String comment ;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime commented_date ;
    @PrePersist
    public void prePersist() {
        commented_date  = LocalDateTime.now();
    }
}
