package com.siwoo.webappag1.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Locale;

@Controller
@RequestMapping({"/","/home","/HOME","/index","/INDEX"})
public class HomeController {

    @GetMapping
    public String home() {
        return "index";
    }

    @ResponseBody
    @GetMapping("/locale")
    public HashMap locale(Locale locale) {
        HashMap map = new HashMap();
        map.put("locale", locale);
        return map;
    }

}
