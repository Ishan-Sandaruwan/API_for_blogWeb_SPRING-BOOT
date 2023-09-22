package com.DevIsh.blogWeb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "blog")
public class Blog {
    @Id
    private int blog_id;
    private int user_id;
    private String title;
    private String description;
    private String image_path;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime created_date;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime last_update;
    @PrePersist
    public void prePersist() {
        last_update  = LocalDateTime.now();
        created_date = LocalDateTime.now();
    }
}
