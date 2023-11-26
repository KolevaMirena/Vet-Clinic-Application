package com.vetclinicapp.service.impl;

import com.vetclinicapp.model.entity.User;
import com.vetclinicapp.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class VetClinicAppUserDetailsService implements UserDetailsService {


    private final UserRepository userRepository;

    public VetClinicAppUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

      return   userRepository
                .findByUsername(username)
                .map(this::map)
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found!"));

    }



    private UserDetails map(User user){
      return   org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities(List.of()) // add authorities
                .build();

    }
}
