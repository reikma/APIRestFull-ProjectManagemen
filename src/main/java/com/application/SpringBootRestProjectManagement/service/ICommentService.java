package com.application.SpringBootRestProjectManagement.service;

import com.application.SpringBootRestProjectManagement.entities.Comment;

import java.util.List;
import java.util.Optional;

public interface ICommentService {
    Optional<Comment> findById(Long id);
    List<Comment> findAll();
    void save(Comment comment);
    void deleteById(Long id);
}
