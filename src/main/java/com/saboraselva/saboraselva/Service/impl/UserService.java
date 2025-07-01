package com.saboraselva.saboraselva.Service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.saboraselva.saboraselva.Repo.IUserRepository;
import com.saboraselva.saboraselva.model.Usuario;

public class UserService implements UserDetailsService {
    
    private IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    
}
