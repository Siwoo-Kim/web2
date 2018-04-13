package com.siwoo.webappag1.repository;

import com.siwoo.webappag1.domain.Document;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long>{

    @Query("select d from Document d where d.topic.id = :topicId")
    List<Document> findByTopicId(@Param("topicId") Long topicId);
    @Query("select d from Document d where d.topic.id = :topicId")
    List<Document> findByTopicId(@Param("topicId") Long categoryId, Pageable pageable);
}
