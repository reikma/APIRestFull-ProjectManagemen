package com.application.SpringBootRestProjectManagement.repository;

import com.application.SpringBootRestProjectManagement.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
