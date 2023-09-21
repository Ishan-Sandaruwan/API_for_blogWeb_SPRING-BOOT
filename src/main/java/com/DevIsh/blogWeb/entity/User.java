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
@Table(name = "userData")
public class User {
    @GeneratedValue
    @Id
    private int userId;
    private String email;
    private String userName;
    private String name;
    private String pass;
    private boolean states;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime createdDate;
    @PrePersist
    public void prePersist() {
        createdDate = LocalDateTime.now();
    }
}
