package com.niu.demo.service;

import com.niu.demo.entity.Article;
import com.niu.demo.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public Article addArticle(Article article) {
        return articleRepository.save(article);
    }
}
