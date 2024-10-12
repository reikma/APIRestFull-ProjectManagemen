package com.application.SpringBootRestProjectManagement.persistence.impl;

import com.application.SpringBootRestProjectManagement.entities.Project;
import com.application.SpringBootRestProjectManagement.persistence.IProjectDAO;
import com.application.SpringBootRestProjectManagement.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class ProjectDAOImpl implements IProjectDAO {

    @Autowired
    private ProjectRepository projectRepository;


    @Override
    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public List<Project> findAll() {
        return (List<Project>) projectRepository.findAll();
    }

    @Override
    public void save(Project project) {
        projectRepository.save(project);

    }

    @Override
    public void deleteById(Long id) {
        projectRepository.deleteById(id);

    }
}
