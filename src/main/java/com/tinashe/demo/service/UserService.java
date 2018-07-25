package com.tinashe.demo.service;

import com.tinashe.demo.entity.User;

import java.util.List;

public interface UserService {
    User getUserInformation(Long id);

    List<User> findAllUsers();

    Void createUser(User user);

    Void updateUser(User user);

}
