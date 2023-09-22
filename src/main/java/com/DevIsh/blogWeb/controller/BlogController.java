package com.DevIsh.blogWeb.controller;


import com.DevIsh.blogWeb.entity.Blog;
import com.DevIsh.blogWeb.entity.User;
import com.DevIsh.blogWeb.service.BlogMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/blog/blog")
public class BlogController {
    @Autowired
    private BlogMService blogService;

    @PostMapping("/addBlog")
    public Blog addBlog(@RequestBody Blog blog){
        System.out.println(blog);
        return blogService.addBlog(blog);
    }

    @GetMapping("/getBlog/{blog_id}")
    public Blog getBlog(@PathVariable int blog_id){
        return blogService.getBlog(blog_id);
    }

    @GetMapping("/getBlogs/{count}")
    public List<Blog> getBlogs(@PathVariable int count){
        System.out.println(count);
        return blogService.getBlogs(count);
    }

    @GetMapping("/getBlogsOfUser/{user_id}")
    public List<Blog> getBlogsOfUser(@PathVariable int user_id){
        System.out.println(user_id);
        return blogService.getBlogsOfUser(user_id);
    }

    @PutMapping("/updateBlog/{blog_id}")
    public String updateBlog( @PathVariable int blog_id, @RequestBody Blog blog)
    {
        System.out.println(blog_id+"  "+blog);
        return blogService.updateBlog(blog_id, blog);
    }

    @DeleteMapping("/DeleteBlog/{blog_id}")
    public String DeleteBlog(@PathVariable int blog_id)
    {
        return blogService.deleteBlog(blog_id);
    }

}
