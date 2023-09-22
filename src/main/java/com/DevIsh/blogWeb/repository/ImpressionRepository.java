package com.DevIsh.blogWeb.repository;

import com.DevIsh.blogWeb.entity.Impression;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ImpressionRepository extends JpaRepository<Impression, Integer> {

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM impression WHERE blog_id = :blog_id", nativeQuery = true)
    void deleteRowsByBlogId(int blog_id);

    @Query(value = "SELECT * FROM impression WHERE blog_id = :blog_id", nativeQuery = true)
    Impression findByBlogId(int blog_id);
}
