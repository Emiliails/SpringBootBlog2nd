package com.niu.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ArticleType {

    @Id
    @GeneratedValue
    private int articleTypeId;
    private String articleTypeName;
    private String articleTypeStatus;

    @ManyToOne
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "articleType")
    private Set<Article> articles = new HashSet<>();

    public ArticleType() {

    }

    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getArticleTypeId() {
        return articleTypeId;
    }

    public void setArticleTypeId(int articleTypeId) {
        this.articleTypeId = articleTypeId;
    }

    public String getArticleTypeName() {
        return articleTypeName;
    }

    public void setArticleTypeName(String articleTypeName) {
        this.articleTypeName = articleTypeName;
    }

    public String getArticleTypeStatus() {
        return articleTypeStatus;
    }

    public void setArticleTypeStatus(String articleTypeStatus) {
        this.articleTypeStatus = articleTypeStatus;
    }
}
