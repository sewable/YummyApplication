package com.yummy.blog.post;

import com.yummy.blog.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostWebController {

    @Autowired
    private PostService postService;

    @GetMapping("/blog")
    public String getPosts(Model model) {
        model.addAttribute("posts", postService.getPosts());
        return "blog/index.html";
    }
}
