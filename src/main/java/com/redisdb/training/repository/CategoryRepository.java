package com.redisdb.training.repository;

import com.redisdb.training.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByname(String name);

    Category findBycategoryId(Long id);
}
