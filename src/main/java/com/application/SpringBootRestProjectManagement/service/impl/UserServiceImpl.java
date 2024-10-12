package com.application.SpringBootRestProjectManagement.service.impl;

import com.application.SpringBootRestProjectManagement.entities.User;
import com.application.SpringBootRestProjectManagement.persistence.IUserDAO;
import com.application.SpringBootRestProjectManagement.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDAO userDAO;

    @Override
    public Optional<User> findById(Long id) {
        return userDAO.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public void save(User user) {
        userDAO.save(user);

    }

    @Override
    public void deleteById(Long id) {
        userDAO.deleteById(id);

    }
}
