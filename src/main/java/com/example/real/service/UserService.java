package com.example.real.service;

import com.example.real.model.User;
import com.example.real.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User u1){
        // encrypt password before sacing in db
        u1.setPassword(passwordEncoder.encode(u1.getPassword()));
        return userRepository.save(u1);
    }
}
