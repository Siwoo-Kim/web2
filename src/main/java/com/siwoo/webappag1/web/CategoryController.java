package com.siwoo.webappag1.web;

import com.siwoo.webappag1.domain.Category;
import com.siwoo.webappag1.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping
    public List<Category> categories() {
        return categoryRepository.findAllFetchAll();
    }

    @GetMapping("/topic/{topicId}")
    public Category byTopicId(@PathVariable Long topicId) {
        log.warn(topicId + "");
        return categoryRepository.findByTopic(topicId);
    }

}
