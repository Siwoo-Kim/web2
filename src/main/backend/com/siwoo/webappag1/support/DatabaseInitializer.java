package com.siwoo.webappag1.support;

import com.siwoo.webappag1.domain.Category;
import com.siwoo.webappag1.domain.Topic;
import com.siwoo.webappag1.domain.WebPage;
import com.siwoo.webappag1.repository.CategoryRepository;
import com.siwoo.webappag1.repository.TopicRepository;
import com.siwoo.webappag1.repository.WebPageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Component
@Transactional
public class DatabaseInitializer implements CommandLineRunner{

    @Autowired
    WebPageRepository webPageRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    TopicRepository topicRepository;

    @Value("${app.hostname}")
    String hostname;
    @Value("${app.port}")
    int port;

    @Override
    public void run(String... args) {
        List<WebPage> webPages = FixtureFactory.webPages(hostname,port);
        webPageRepository.saveAll(webPages);

        WebPage language = webPageRepository.findByName("LANGUAGE");
        List<Category> categories = FixtureFactory.languageCategories(hostname,port);
        language.setCategories(categories);
        categoryRepository.saveAll(categories);

        Category java = categoryRepository.findByName("JAVA");
        List<Topic> topics = FixtureFactory.javaTopics(java, hostname, port);
        topicRepository.saveAll(topics);
        topicRepository.findAll().forEach(topic -> log.warn(topic + ""));
    }
}
