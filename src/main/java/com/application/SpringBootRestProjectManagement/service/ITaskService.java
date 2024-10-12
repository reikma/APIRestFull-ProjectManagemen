package com.application.SpringBootRestProjectManagement.service;

import com.application.SpringBootRestProjectManagement.entities.Task;

import java.util.List;
import java.util.Optional;

public interface ITaskService {
    Optional<Task> findByID(Long id);
    List<Task> findAll();
    void save(Task task);
    void deleteById(Long id);
}
