package com.niu.demo.repository;

import com.niu.demo.entity.Article;
import com.niu.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
    List<Article> findByUser(User user);
}
