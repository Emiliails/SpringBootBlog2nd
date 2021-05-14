package com.niu.demo.controller;

import com.niu.demo.entity.Article;
import com.niu.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/addArticle")
    public String addArticle() {
        return "addArticle";
    }

    @PostMapping("/addArticle")
    @ResponseBody
    public Article addArticle(Article article) {
        articleService.add(article);
        return article;
    }
}
