package com.niu.demo.controller;

import com.niu.demo.entity.ArticleType;
import com.niu.demo.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleTypeController {
    @Autowired
    private ArticleTypeService service;

    @GetMapping("/addArticleType")
    public String addArticleType() {
        return "addArticleType";
    }

    @PostMapping("/addArticleType")
    public String addArticleType(ArticleType articleType) {
        service.addArticleType(articleType);
        return "addArticleTypeResult";
    }
}
