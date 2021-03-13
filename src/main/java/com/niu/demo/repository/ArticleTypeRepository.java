package com.niu.demo.repository;

import com.niu.demo.entity.ArticleType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleTypeRepository extends JpaRepository<ArticleType,Integer> {
}
