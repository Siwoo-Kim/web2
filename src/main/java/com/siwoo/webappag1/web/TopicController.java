package com.siwoo.webappag1.web;

import com.siwoo.webappag1.domain.Document;
import com.siwoo.webappag1.domain.Topic;
import com.siwoo.webappag1.repository.DocumentRepository;
import com.siwoo.webappag1.repository.TopicRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/topic")
public class TopicController {

    @Autowired TopicRepository topicRepository;
    @Autowired DocumentRepository documentRepository;

    @GetMapping("/category/{categoryId}")
    public List<Topic> byCategory(@PathVariable("categoryId") Long categoryId) {
        return topicRepository.findByCategoryId(categoryId);
    }

//    @GetMapping(path="/{topicId}/document")
//    public List<Document> documentsByTopic(@PathVariable("topicId") Long topicId) {
//        return documentRepository.findByTopicId(topicId);
//    }

    @GetMapping(path="/{topicId}/document")
    public List<Document> documentsByTopicWithSize(@PathVariable("topicId") Long topicId,
                                                   @PageableDefault(size = 5,page = 0) Pageable pageable) {
        return documentRepository.findByTopicId(topicId, pageable);
    }

    @GetMapping
    public List<Topic> topics() {
        return  topicRepository.findAll();
    }

    @GetMapping("/{id}")
    public Topic byId(@PathVariable("id") Long id) {
        System.out.println("Handled");
        return this.topicRepository.findById(id).get();
    }
}
