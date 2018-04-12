package com.siwoo.webappag1.web;

import com.siwoo.webappag1.domain.WebPage;
import com.siwoo.webappag1.repository.WebPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/webpage")
public class WebPageController {

    @Autowired
    WebPageRepository webPageRepository;

    @GetMapping
    List<WebPage> list() {
        return webPageRepository.findAllFetchAll();
    }

    @GetMapping("/{name}")
    WebPage byName(@PathVariable String name) {
        return webPageRepository.findByNameFetchAll(name);
    }

    @PostMapping
    WebPage save(@RequestBody WebPage webPage) {
        return webPageRepository.save(webPage);
    }
}
