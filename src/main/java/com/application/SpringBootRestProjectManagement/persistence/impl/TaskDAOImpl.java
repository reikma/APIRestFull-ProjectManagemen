package com.application.SpringBootRestProjectManagement.persistence.impl;


import com.application.SpringBootRestProjectManagement.entities.Task;
import com.application.SpringBootRestProjectManagement.persistence.ITaskDAO;
import com.application.SpringBootRestProjectManagement.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TaskDAOImpl implements ITaskDAO {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Optional<Task> findByID(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public List<Task> findAll() {
        return (List<Task>) taskRepository.findAll();
    }

    @Override
    public void save(Task task) {
        taskRepository.save(task);

    }

    @Override
    public void deleteById(Long id) {
        taskRepository.deleteById(id);

    }
}
