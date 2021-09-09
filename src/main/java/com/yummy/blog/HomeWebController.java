package com.yummy.blog;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeWebController {

    @GetMapping("/blog")
    public String getHome() {
        return "blog/index.html";
    }
}
