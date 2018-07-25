package com.tinashe.demo.manager;

import com.tinashe.demo.dao.UserRepository;
import com.tinashe.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class UserManagerImpl implements UserManager{

    @Autowired
    UserRepository userRepository;

    @Override
    public User getUserInformation(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Void createUser(User user) {
        userRepository.save(user);
        return null;
    }

    @Override
    public Void updateUser(User user) {

        User updateUser = userRepository.findOne(user.getId());

        updateUser.setFirstName(user.getFirstName());
        updateUser.setLastName(user.getLastName());
        updateUser.setUserName(user.getUserName());
        userRepository.save(updateUser);
        return null;
    }

}
