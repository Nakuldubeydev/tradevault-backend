package com.example.real.repository;

import com.example.real.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    // pre returned method in jpa repository is here...
    // spring genererate sql automatically from method name


    Optional<User> findByUsername(String username);
}
