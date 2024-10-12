package com.application.SpringBootRestProjectManagement.service.impl;

import com.application.SpringBootRestProjectManagement.entities.Project;
import com.application.SpringBootRestProjectManagement.persistence.IProjectDAO;
import com.application.SpringBootRestProjectManagement.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProjectServiceImpl implements IProjectService {

    @Autowired
    private IProjectDAO projectDAO;

    @Override
    public Optional<Project> findById(Long id) {
        return projectDAO.findById(id);
    }

    @Override
    public List<Project> findAll() {
        return projectDAO.findAll();
    }

    @Override
    public void save(Project project) {
        projectDAO.save(project);

    }

    @Override
    public void deleteById(Long id) {
        projectDAO.deleteById(id);

    }
}
