package com.yummy.blog.post;

import com.yummy.blog.post.dto.PostDto;
import com.yummy.blog.post.entity.PostEntity;
import com.yummy.blog.post.form.PostForm;
import com.yummy.blog.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
public class PostWebController {

    @Autowired
    private PostService postService;

    @GetMapping("/blog/recipes")
    public String getPosts(Model model) {
        model.addAttribute("posts", postService.getPosts());
        return "blog/recipes.html";
    }

    @GetMapping("/blog/recipes/{id}")
    public String getPost(@PathVariable("id") Long id, Model model) {
        model.addAttribute("post", postService.getPost(id));
        return "blog/recipe.html";
    }

    @PostMapping("/blog/recipes")
    public String createPost(@RequestBody @Valid PostForm form, Model model) {
        PostDto post = postService.create(form);
        model.addAttribute("post", post);
        return "redirect:/blog/recipes/" + post.getId();
    }

    @PutMapping("/blog/recipes/{id}")
    public String updatePost(@PathVariable("id") Long id,
                             @RequestBody PostEntity entity,
                             Model model) {
        PostDto post = postService.update(entity.setId(id));
        model.addAttribute("post", post);
        return "redirect:/blog/recipe/" + post.getId();
    }

    @PostMapping("/blog/recipes/{id}/delete")
    public String deletePost(@PathVariable("id") Long id) {
        postService.delete(id);
        return "redirect:/blog/recipes";
    }
}
