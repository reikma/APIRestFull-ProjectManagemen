package com.application.SpringBootRestProjectManagement.repository;

import com.application.SpringBootRestProjectManagement.entities.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

}
