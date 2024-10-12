package com.application.SpringBootRestProjectManagement.service;

import com.application.SpringBootRestProjectManagement.entities.Project;

import java.util.List;
import java.util.Optional;

public interface IProjectService {

    Optional<Project> findById(Long id);
    List<Project> findAll();
    void save(Project project);
    void deleteById(Long id);
}
