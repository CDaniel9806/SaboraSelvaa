package com.saboraselva.saboraselva.Service.impl;

import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.saboraselva.saboraselva.Repo.IUserRepository;
import com.saboraselva.saboraselva.model.Usuario;

@Service
public class UserService implements UserDetailsService {
    
    private IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = userRepository.findByNombre(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().getName().toString());

        return new org.springframework.security.core.userdetails.User(
            user.getNombre(),
            user.getPassword(),
            Collections.singletonList(authority)
        );
    }
}
