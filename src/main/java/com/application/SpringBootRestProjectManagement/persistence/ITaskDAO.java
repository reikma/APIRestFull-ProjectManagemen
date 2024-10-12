package com.application.SpringBootRestProjectManagement.persistence;

import com.application.SpringBootRestProjectManagement.entities.Task;

import java.util.List;
import java.util.Optional;

public interface ITaskDAO {

    Optional<Task> findByID(Long id);
    List<Task> findAll();
    void save(Task task);
    void deleteById(Long id);

}
