package com.DevIsh.blogWeb.service;

import com.DevIsh.blogWeb.entity.Blog;
import com.DevIsh.blogWeb.entity.Comment;
import com.DevIsh.blogWeb.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public Comment AddComment(Comment comment){
        return commentRepository.save(comment);
    }

    public List<Comment> getCommentsForBlog(int blog_id){
        return commentRepository.getCommentsForBlog(blog_id);
    }

    public String deleteComment(int comment_id){

        try {
            Comment comment = commentRepository.findById(comment_id).orElse(null);

            if (comment != null) {
                commentRepository.deleteById(comment_id);
                return "Comment deleted successfully!";
            } else {
                return "Comment not found";
            }
        } catch (Exception e) {
            return "An error occurred while deleting the comment";
        }
    }
}
