package com.DevIsh.blogWeb.service;

import com.DevIsh.blogWeb.entity.User;
import com.DevIsh.blogWeb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;


import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User addNewUser(User user){

        return userRepository.save(user);
    }

//    public User getUser(int userId){
//        return userRepository.findOnce(userId);
//    }
    public User getUser(int id) {
        User user = userRepository.findOnce(id);
        if (user != null) {
            return user;
        } else {
            return null;
        }
    }

    public List<User> getUsers(int c) {

        return userRepository.findLastNUsers(c);
    }

    public List<User> getAllUsers(){
        return userRepository.findAllActive();
    }

    public List<User> getAllDeactiveUsers(){
        return userRepository.findAllDeactiveUsers();
    }

    public String updatePassword(int userId, String newPassword) {
        User user = userRepository.findById(userId).orElse(null);
        if(user!=null){
            user.setPass(newPassword);
            userRepository.save(user);
            return "password changed !";
        }else{
            return "user not found !!";
        }
    }

    public String disableUser(int userId, boolean newState) {
        User user = userRepository.findById(userId).orElse(null);
        if(user!=null){
            user.setStates(newState);
            userRepository.save(user);
            return "User Deleted !";
        }else{
            return "user not found !!";
        }
    }

}
