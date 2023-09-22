package com.DevIsh.blogWeb.repository;

import com.DevIsh.blogWeb.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BlogRepository extends JpaRepository <Blog,Integer> {
    @Query(value = "SELECT * FROM blog ORDER BY blog_id DESC LIMIT ?1", nativeQuery = true)
    List<Blog> findLastNBlogs(int c);

    @Query(value = "SELECT * FROM blog WHERE user_id = :user_id ORDER BY blog_id DESC", nativeQuery = true)
    List<Blog> getBlogsOfUser(int user_id);

}
