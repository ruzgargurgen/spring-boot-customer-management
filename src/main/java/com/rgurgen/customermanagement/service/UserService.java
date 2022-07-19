package com.rgurgen.customermanagement.service;

import com.rgurgen.customermanagement.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAllUsers();

    User saveUser(User user);

    Optional<User> findByUsername(String username);

    void makeAdmin(String username);
}
