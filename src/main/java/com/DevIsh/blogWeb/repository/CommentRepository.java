package com.DevIsh.blogWeb.repository;

import com.DevIsh.blogWeb.entity.Comment;
import com.DevIsh.blogWeb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Integer> {

    @Query(value = "SELECT * FROM comments where blog_id = :blog_id ORDER BY comment_id DESC", nativeQuery = true)
    List<Comment> getCommentsForBlog(int blog_id);

}
