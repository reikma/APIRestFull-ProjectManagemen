package com.application.SpringBootRestProjectManagement.persistence;

import com.application.SpringBootRestProjectManagement.entities.User;
import java.util.List;
import java.util.Optional;

public interface IUserDAO {

    Optional<User> findById(Long id);
    List<User> findAll();
    void save(User user);
    void deleteById(Long id);
}
