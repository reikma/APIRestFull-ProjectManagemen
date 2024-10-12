package com.application.SpringBootRestProjectManagement.persistence;

import com.application.SpringBootRestProjectManagement.entities.Project;

import java.util.List;
import java.util.Optional;

public interface IProjectDAO {

    Optional<Project> findById(Long id);
    List<Project> findAll();
    void save(Project project);
    void deleteById(Long id);
}
