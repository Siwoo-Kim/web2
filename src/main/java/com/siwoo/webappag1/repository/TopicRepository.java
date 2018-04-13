package com.siwoo.webappag1.repository;

import com.siwoo.webappag1.domain.Category;
import com.siwoo.webappag1.domain.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicRepository extends JpaRepository<Topic, Long> {

    @Query("select t from Topic t where t.category = :category")
    List<Topic> findByCategory(@Param("category") Category category);

    @Query("select t from Topic t where t.category.id = :categoryId")
    List<Topic> findByCategoryId(@Param("categoryId") Long categoryId);
}
