package com.application.SpringBootRestProjectManagement.service;

import com.application.SpringBootRestProjectManagement.entities.User;
import java.util.List;
import java.util.Optional;

public interface IUserService {

    Optional<User> findById(Long id);
    List<User> findAll();
    void save(User user);
    void deleteById(Long id);
}
