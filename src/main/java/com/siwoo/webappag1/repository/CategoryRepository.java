package com.siwoo.webappag1.repository;

import com.siwoo.webappag1.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long>{

    @Query("select distinct c from Category c inner join fetch c.webPage.images i")
    List<Category> findAllFetchAll();

    @Query("select c from Category c where upper(c.name) = :name")
    Category findByName(@Param("name") String name);
}
