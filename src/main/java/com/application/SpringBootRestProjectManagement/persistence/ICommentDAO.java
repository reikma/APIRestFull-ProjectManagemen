package com.application.SpringBootRestProjectManagement.persistence;

import com.application.SpringBootRestProjectManagement.entities.Comment;

import java.util.List;
import java.util.Optional;

public interface ICommentDAO {

    Optional<Comment> findById(Long id);
    List<Comment> findAll();
    void save(Comment comment);
    void deleteById(Long id);
}
