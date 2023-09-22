package com.DevIsh.blogWeb.controller;

import com.DevIsh.blogWeb.entity.Comment;
import com.DevIsh.blogWeb.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/blog/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/addComment")
    public Comment AddComment(@RequestBody Comment comment){
        return commentService.AddComment(comment);
    }

    @GetMapping("/getCommentsForBlog/{blog_id}")
    public List<Comment> getCommentsForBlog(@PathVariable int blog_id){
        return commentService.getCommentsForBlog(blog_id);
    }

    @DeleteMapping("/deleteComment/{comment_id}")
    public String deleteComment(@PathVariable int comment_id){
        return commentService.deleteComment(comment_id);
    }

}
