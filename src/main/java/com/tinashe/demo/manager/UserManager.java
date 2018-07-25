package com.tinashe.demo.manager;

import com.tinashe.demo.entity.User;

import java.util.List;

public interface UserManager {
    User getUserInformation(Long id);

    List<User> findAllUsers();

    Void createUser(User user);

    Void updateUser(User user);

}
