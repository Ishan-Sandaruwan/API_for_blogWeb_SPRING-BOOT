package com.DevIsh.blogWeb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "impression")
public class Impression {
    @Id
    private int imp_id;
    private int blog_id;
    private int views_count;
    private int likes_count;
    private int dislike_count;
    private int comment_count;
}
