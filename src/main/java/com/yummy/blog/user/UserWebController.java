package com.yummy.blog.user;

import com.yummy.blog.user.dto.UserDto;
import com.yummy.blog.user.entity.UserEntity;
import com.yummy.blog.user.form.UserForm;
import com.yummy.blog.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
public class UserWebController {

    @Autowired
    private UserService userService;

    @PostMapping("/blog/recipes/")
    public String createUser(@RequestBody @Valid UserForm form, Model model) {
        UserDto user = userService.create(form);
        model.addAttribute("user", user);
        return "redirect:/blog/recipes";
    }

    @PutMapping("/blog/recipes/{username}")
    public String updateUser(@PathVariable("username") String username,
                             @RequestBody UserEntity userEntity,
                             Model model) {
        UserDto user = userService.update(userEntity);
        model.addAttribute("user", user);
        return "redirect:/blog/recipes";
    }
}
