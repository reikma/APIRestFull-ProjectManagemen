package com.application.SpringBootRestProjectManagement.service.impl;

import com.application.SpringBootRestProjectManagement.entities.Task;
import com.application.SpringBootRestProjectManagement.persistence.ITaskDAO;
import com.application.SpringBootRestProjectManagement.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements ITaskService {

    @Autowired
    private ITaskDAO taskDAO;

    @Override
    public Optional<Task> findByID(Long id) {
        return taskDAO.findByID(id);
    }

    @Override
    public List<Task> findAll() {
        return taskDAO.findAll();
    }

    @Override
    public void save(Task task) {

        taskDAO.save(task);

    }

    @Override
    public void deleteById(Long id) {
        taskDAO.deleteById(id);

    }
}
