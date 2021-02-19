package com.bootcamp.springboot.service.impl;

import com.bootcamp.springboot.model.Users;
import com.bootcamp.springboot.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service("userDetailService")
public class UsersDetailServiceImpl implements UserDetailsService{
    private final Logger logger = LoggerFactory.getLogger(UsersDetailServiceImpl.class);

    @Autowired
    UsersService usersService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersService.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Username " + username + " Not found.");
        }else if (!user.isActive()){
            throw new BadCredentialsException("User is not active");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), loadAuthorities(user));

    }

    private Collection<? extends GrantedAuthority> loadAuthorities(Users user){
        Set<GrantedAuthority> authorities = new HashSet<>();
        logger.info("{}", user.getRoles().toArray());
        user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRoleName())));
        return authorities;
    }
}
