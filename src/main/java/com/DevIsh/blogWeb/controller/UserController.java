package com.DevIsh.blogWeb.controller;

import com.DevIsh.blogWeb.entity.User;
import com.DevIsh.blogWeb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/blog/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        System.out.println(user);
        return userService.addNewUser(user) ;
    }

    @GetMapping("/getUser/{userId}")
    public User getUser(@PathVariable int userId){
        System.out.println(userId);
        return userService.getUser(userId);
    }

    @GetMapping("/getUsers/{count}")
    public List<User> getUsers(@PathVariable int count){
        System.out.println(count);
        return userService.getUsers(count);
    }

    @GetMapping("/getUsers/All")
    public List<User> GetAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/getUsers/Deactivated")
    public List<User> getAllDeactivated(@RequestParam int key) {
        if (key == 100200300) {
            return userService.getAllDeactiveUsers();
        }
        return null;
    }

    @PatchMapping("/{userId}/updatePassword")
    public String updatePassword(
            @PathVariable int userId,
            @RequestParam String newPassword) {
        System.out.println(userId+"  "+newPassword);
        return userService.updatePassword(userId, newPassword);
    }

    @DeleteMapping("/{userId}/DeleteUser")
    public String disableUser(
            @PathVariable int userId) {
        return userService.disableUser(userId, false);
    }

}
