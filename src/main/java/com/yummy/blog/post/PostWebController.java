package com.yummy.blog.post;

import com.yummy.blog.post.dto.PostDto;
import com.yummy.blog.post.entity.PostEntity;
import com.yummy.blog.post.form.PostForm;
import com.yummy.blog.post.service.PostService;
import com.yummy.blog.user.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.security.Principal;

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

    @GetMapping("/blog/add")
    public String showCreateForm(Model model, Principal principal) {
        if (principal == null) {
            return "redirect:/login";
        }
        PostForm post = new PostForm();
        UserDto user = new UserDto();
        model.addAttribute("post", post);
        model.addAttribute("user", user);
        return "blog/create.html";
    }

    @PostMapping("/add")
    public String createPost(@ModelAttribute @Valid PostForm form, Principal principal) {
        PostDto post = postService.create(form, principal);
        return "redirect:blog/recipes/" + post.getId();
    }

    @GetMapping("/blog/edit")
    public String showEditForm(Model model, PostEntity entity, Principal principal) {
        if (principal == null) {
            return "redirect:/login";
        }
        model.addAttribute("post", entity);
        return "blog/edit.html";
    }

    @PutMapping("/edit/{id}")
    public String updatePost(@PathVariable("id") Long id,
                             @RequestBody PostEntity entity,
                             Model model) {
        PostDto post = postService.update(entity.setId(id));
        model.addAttribute("post", post);
        return "redirect:/blog/recipe/" + post.getId();
    }

    @PostMapping("/blog/recipes/{id}/delete")
    public String deletePost(@PathVariable("id") Long id, Principal principal) {
        if (principal == null) {
            return "redirect:/login";
        }
        postService.delete(id, principal);
        return "redirect:/blog/recipes";
    }
}
