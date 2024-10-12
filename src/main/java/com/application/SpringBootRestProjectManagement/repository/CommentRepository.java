package com.application.SpringBootRestProjectManagement.repository;

import com.application.SpringBootRestProjectManagement.entities.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
}
