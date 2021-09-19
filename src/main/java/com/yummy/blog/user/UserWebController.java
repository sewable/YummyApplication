package com.yummy.blog.user;

import com.yummy.blog.user.dto.UserDto;
import com.yummy.blog.user.entity.UserEntity;
import com.yummy.blog.user.form.UserForm;
import com.yummy.blog.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserWebController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "/blog/login.html";
    }

    @GetMapping("/blog/users")
    public String getUsers(Model model) {
        List<UserDto> users = userService.getUsers();
        model.addAttribute(users);
        return "redirect:/blog/recipes";
    }

    @GetMapping("/blog/users/{username}")
    public String getUser(@PathVariable("username") String username, Model model) {
        UserDto user = userService.getUser(username);
        model.addAttribute(user);
        return "redirect:/blog/recipes";
    }

    @PostMapping("/blog/users/")
    public String createUser(@RequestBody @Valid UserForm form, Model model) {
        UserDto user = userService.create(form);
        model.addAttribute("user", user);
        return "redirect:/blog/recipes";
    }

    @PutMapping("/blog/users/{username}")
    public String updateUser(@PathVariable("username") String username,
                             @RequestBody UserEntity userEntity,
                             Model model) {
        UserDto user = userService.update(userEntity);
        model.addAttribute("user", user);
        return "redirect:/blog/recipes";
    }
}
