package com.DevIsh.blogWeb.service;

import com.DevIsh.blogWeb.entity.Blog;
import com.DevIsh.blogWeb.entity.User;
import com.DevIsh.blogWeb.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BlogMService {
    @Autowired
    private BlogRepository blogRepository;

    public Blog addBlog(Blog blog){
        return blogRepository.save(blog) ;
    }

    public Blog getBlog(int id){
        Blog blog = blogRepository.findById(id).orElse(null);
        if(blog != null){
            return blog;
        }else {
            return null;
        }
    }

    public List<Blog> getBlogs(int c) {
        return blogRepository.findLastNBlogs(c);
    }

    public String updateBlog(int blog_id,Blog blog){

        Blog blog1 = blogRepository.findById(blog_id).orElse(null);

        if(blog1 != null){

            blog1.setDescription(blog.getDescription());
            blog1.setTitle(blog.getTitle());
            blog1.setLast_update(LocalDateTime.now());
            blog1.setImage_path(blog.getImage_path());

            blogRepository.save(blog1);
            return "Blog updated succesfully !!! ";
        }else{
            return "Blog not found !!";
        }
    }

    public String deleteBlog(int blog_id) {
        Optional<Blog> optionalBlog = blogRepository.findById(blog_id);

        if (optionalBlog.isPresent()) {
            blogRepository.deleteById(blog_id);
            return "Blog deleted successfully!";
        } else {
            return "Cannot find blog";
        }
    }

    public List<Blog> getBlogsOfUser(int user_id){
        return blogRepository.getBlogsOfUser(user_id);
    }

}