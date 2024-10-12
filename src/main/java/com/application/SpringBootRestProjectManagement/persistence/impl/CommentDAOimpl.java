package com.application.SpringBootRestProjectManagement.persistence.impl;

import com.application.SpringBootRestProjectManagement.entities.Comment;
import com.application.SpringBootRestProjectManagement.persistence.ICommentDAO;
import com.application.SpringBootRestProjectManagement.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class CommentDAOimpl implements ICommentDAO {

    @Autowired
    private CommentRepository commentRepository;


    @Override
    public Optional<Comment> findById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public List<Comment> findAll() {
        return (List<Comment>) commentRepository.findAll();
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void deleteById(Long id) {
        commentRepository.deleteById(id);

    }
}
