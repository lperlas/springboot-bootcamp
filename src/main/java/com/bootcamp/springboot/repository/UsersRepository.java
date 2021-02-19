package com.bootcamp.springboot.repository;

import com.bootcamp.springboot.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findById(long id);
    Users findByUsername(String username);
}
