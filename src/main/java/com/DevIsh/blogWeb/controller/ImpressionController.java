package com.DevIsh.blogWeb.controller;

import com.DevIsh.blogWeb.entity.Impression;
import com.DevIsh.blogWeb.service.ImpressionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/blog/impress")
public class ImpressionController {
    @Autowired
    private ImpressionService impressionService;

    @PostMapping("/addNew/{blog_id}")
    public String addNewImpression(@PathVariable int blog_id){
        return impressionService.addNewImpression(blog_id);
    }

    @GetMapping("/getAllImp")
    public List<Impression> getAllImp(@RequestParam int key){
        if (key == 100200300) {
            return impressionService.getAllImp();
        }
        return null;
    }
    @GetMapping("/getImp/{blog_id}")
    public Impression getImp(@PathVariable int blog_id){
        return impressionService.getImp(blog_id);
    }

    @PutMapping("/update/{blog_id}")
    public String updateImp(@PathVariable int blog_id, @RequestParam String what,@RequestParam String why){
        System.out.println(blog_id+" ||  "+what+"  ||  "+why);
        return impressionService.updateImpPlus(blog_id,what,why);
    }

    @DeleteMapping("/delete/{blog_id}")
    public String deleteImpression(@PathVariable int blog_id){
        return impressionService.deleteImpression(blog_id);
    }
}
