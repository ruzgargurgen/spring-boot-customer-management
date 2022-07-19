package com.rgurgen.customermanagement.service.impl;

import com.rgurgen.customermanagement.model.Role;
import com.rgurgen.customermanagement.model.User;
import com.rgurgen.customermanagement.repos.UserRepository;
import com.rgurgen.customermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository UserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        return UserRepository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return UserRepository.findByUserName(username);
    }

    @Override
    public List<User> findAllUsers() {
        List<User> users = UserRepository.findAll();
        return users;
    }

    @Override
    @Transactional
    public void makeAdmin(String username) {
        UserRepository.updateUserRole(username, Role.ADMIN);
    }
}