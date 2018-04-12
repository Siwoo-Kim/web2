package com.siwoo.webappag1.repository;

import com.siwoo.webappag1.domain.WebPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface WebPageRepository extends JpaRepository<WebPage, String>{

    @Query("select w from WebPage w where upper(w.name) = upper(:name)")
    WebPage findByName(@Param("name") String name);

    @Query("select distinct w from WebPage w inner join fetch w.images where upper(w.name) = upper(:name)")
    WebPage findByNameFetchAll(@Param("name") String name);

    @Query("select w from WebPage w where w.basicTime.created = (select max(w2.basicTime.created) from WebPage w2)")
    WebPage findTopByBasicTimeCreated();

    @Query("select w from WebPage w where w.basicTime.updated = (select max(w2.basicTime.updated) from WebPage w2)")
    WebPage findTopBasicTimeUpdated();

    @Query("select key(i), value(i) from WebPage w inner join w.images i where upper(w.name) = upper(:name)")
    Map<String,String> findImagesByName(@Param("name") String name);

    @Query("select distinct  w from WebPage w inner join fetch w.images")
    List<WebPage> findAllFetchAll();

    @Query("select w from WebPage w where w.categories is empty")
    List<WebPage> findByCategoriesIsEmpty();

    @Query("select w from WebPage w where w.categories is not empty")
    List<WebPage> findByCategoriesIsNotEmpty();
}
