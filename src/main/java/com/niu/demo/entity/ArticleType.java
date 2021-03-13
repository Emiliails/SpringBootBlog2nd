package com.niu.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ArticleType {

    @Id
    @GeneratedValue
    private int articleTypeId;

    private String articleTypeName;
    private String articleTypeStatus;

    public ArticleType() {

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
