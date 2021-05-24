package com.niu.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private int commentId;

    private String commentContent;

    @ManyToOne
    @JsonIgnore
    private User user;

    @ManyToOne
    @JsonIgnore
    private Article article;

    @OneToMany(mappedBy = "comment")
    private Set<Reply> replies =new HashSet<>();


    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Set<Reply> getReplies() {
        return replies;
    }

    public void setReplies(Set<Reply> replies) {
        this.replies = replies;
    }
}
