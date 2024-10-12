package com.application.SpringBootRestProjectManagement.repository;

import com.application.SpringBootRestProjectManagement.entities.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
}
