package com.siwoo.webappag1.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/","/home","/HOME","/index","/INDEX"})
public class HomeController {

    @GetMapping
    public String home() {
        return "index";
    }
}
