package com.niu.demo.service;

import com.niu.demo.entity.Article;
import com.niu.demo.entity.User;
import com.niu.demo.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public Article add(Article article) {
        article.setUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return articleRepository.save(article);
    }
}
