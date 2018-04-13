package com.siwoo.webappag1.web;

import com.siwoo.webappag1.web.support.Message;
import com.siwoo.webappag1.web.support.MessageResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("message")
public class MessageController {

    @Autowired MessageResolver messageResolver;

    @GetMapping
    Message getMessage(@RequestParam("code") String code, Locale locale) {
        return messageResolver.getMessage(code,locale);
    }
}
