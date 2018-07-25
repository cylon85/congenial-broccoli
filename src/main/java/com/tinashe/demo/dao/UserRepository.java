package com.tinashe.demo.dao;

import com.tinashe.demo.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    User findOne(@Param("user_id") Long id);

    User save(User user);

    List<User> findAll();

}
