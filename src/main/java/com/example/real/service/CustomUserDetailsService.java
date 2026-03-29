package com.example.real.service;

import com.example.real.model.User;
import com.example.real.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // step 1: find user in database
        User u1 =userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: "+ username));


        // step 2: convert to spring security
        return org.springframework.security.core.userdetails.User
                .withUsername(u1.getUsername())
                .password(u1.getPassword())
                .authorities(u1.getRole().name())
                .build();

    }
}
