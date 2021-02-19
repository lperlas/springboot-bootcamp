package com.bootcamp.springboot.service;

import com.bootcamp.springboot.model.Role;
import com.bootcamp.springboot.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository repo;

    public List<Role> getAllRoles(){
        return repo.findAll();
    }

    public Role getRole(long id){
        return repo.findById(id);
    }

    public void addRole(Role role){
        repo.save(role);
    }

    public void updateRole(Role role){
        repo.save(role);
    }

    public void deleteRole(long id){
        repo.deleteById(id);
    }
}
