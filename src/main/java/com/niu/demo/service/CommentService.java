package com.niu.demo.service;

import com.niu.demo.entity.Article;
import com.niu.demo.entity.Comment;
import com.niu.demo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public List<Comment> findByArticle(Article article) {
        return commentRepository.findByArticle(article);
    }

    public Comment findById(int commentId) {
        return commentRepository.findById(commentId).get();
    }
}
