package com.application.SpringBootRestProjectManagement.service.impl;

import com.application.SpringBootRestProjectManagement.entities.Comment;
import com.application.SpringBootRestProjectManagement.persistence.ICommentDAO;
import com.application.SpringBootRestProjectManagement.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CommentServiceImpl implements ICommentService {

    @Autowired
    private ICommentDAO commentDAO;

    @Override
    public Optional<Comment> findById(Long id) {
        return commentDAO.findById(id);
    }

    @Override
    public List<Comment> findAll() {
        return commentDAO.findAll();
    }

    @Override
    public void save(Comment comment) {
        commentDAO.save(comment);

    }

    @Override
    public void deleteById(Long id) {

        commentDAO.deleteById(id);

    }
}
