package com.niu.demo.service;

import com.niu.demo.entity.ArticleType;
import com.niu.demo.repository.ArticleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleTypeService {

    @Autowired
    private ArticleTypeRepository articleTypeRepository;

    public ArticleType addArticleType(ArticleType articleType) {
        return articleTypeRepository.save(articleType);
    }
}
