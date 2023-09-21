package com.DevIsh.blogWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.DevIsh.blogWeb.entity.User;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;

public interface UserRepository extends JpaRepository <User,Integer> {

    @Query(value = "SELECT * FROM user_data where states = 1 ORDER BY user_id DESC LIMIT :c", nativeQuery = true)
    List<User> findLastNUsers(int c);

    @Query(value = "SELECT * FROM user_data where states = 1 ", nativeQuery = true)
    List<User>findAllActive();
    @Query(value = "SELECT * FROM user_data where states = 0 ", nativeQuery = true)
    List<User>findAllDeactiveUsers();
    @Query(value = "SELECT * FROM user_data WHERE states = 1 AND user_id = :id", nativeQuery = true)
    User findOnce(int id);

}
