package com.bootcamp.springboot.repository;

import com.bootcamp.springboot.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findById(long id);
}
