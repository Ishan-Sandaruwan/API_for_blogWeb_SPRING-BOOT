package com.DevIsh.blogWeb.service;

import com.DevIsh.blogWeb.entity.Impression;
import com.DevIsh.blogWeb.repository.ImpressionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpressionService {
    @Autowired
    public ImpressionRepository impressionRepository;

    public String addNewImpression(int blog_id){
        try {
            // Create a new Impression entity
            Impression impression = new Impression();
            impression.setBlog_id(blog_id);
            impression.setViews_count(0);
            impression.setLikes_count(0);
            impression.setDislike_count(0);
            impression.setComment_count(0);

            // Save the new Impression entity to the database
            impressionRepository.save(impression);

            return "Row added";
        } catch (Exception ex) {
            return "An exception occurred: " + ex.getMessage();
        }
    }

    public String deleteImpression(int blog_id){
        try {
            impressionRepository.deleteRowsByBlogId(blog_id);
            return "row deleted successfully";
        }catch (Exception ex){
            return "An exception occurred: " + ex.getMessage();
        }
    }

    public List<Impression> getAllImp(){
        return impressionRepository.findAll();
    }

    public Impression getImp(int blog_id){
        return impressionRepository.findByBlogId(blog_id);
    }

    public String updateImpPlus(int blog_id, String what, String why) {
        try {
            Impression old = this.getImp(blog_id);

            // Check if old is null
            if (old == null) {
                return "Blog not found";
            }

            int oldCount = 0;
            switch (what) {
                case "view":
                    oldCount = old.getViews_count();
                    if(why.equals("plus")){
                        old.setViews_count(oldCount + 1);
                    } else if (why.equals("min")) {
                        old.setViews_count(oldCount - 1);
                    }
                    break;
                case "like":
                    oldCount = old.getLikes_count();
                    if(why.equals("plus")){
                        old.setLikes_count(oldCount + 1);
                    } else if (why.equals("min")) {
                        old.setLikes_count(oldCount - 1);
                    }
                    break;
                case "dislike":
                    oldCount = old.getDislike_count();
                    if(why.equals("plus")){
                        old.setDislike_count(oldCount + 1);
                    } else if (why.equals("min")) {
                        old.setDislike_count(oldCount - 1);
                    }
                    break;
                case "comment":
                    oldCount = old.getComment_count();
                    if(why.equals("plus")) {
                        old.setComment_count(oldCount + 1);
                    } else if (why.equals("min")) {
                        old.setComment_count(oldCount - 1);
                    }
                    break;
                default:
                    return "Invalid operation";
            }

            impressionRepository.save(old);
            return what + " updated successfully!";
        } catch (Exception ex) {
            return "Something went wrong: " + ex.getMessage();
        }
    }


}
