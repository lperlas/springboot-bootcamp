package com.bootcamp.springboot.service;

import com.bootcamp.springboot.model.Users;
import com.bootcamp.springboot.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    public UsersRepository usersRepository;

    public Users findByUsername(String username){
        return usersRepository.findByUsername(username);
    }

    public Optional<Users> findbyId(Long id){
        return usersRepository.findById(id);
    }

    public void save(Users user){
        usersRepository.save(user);
    }

    public Users update(Users user){
        return usersRepository.save(user);
    }

    public List<Users> findAll(){
        return usersRepository.findAll();
    }
}
