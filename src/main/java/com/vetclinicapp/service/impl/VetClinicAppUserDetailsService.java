package com.vetclinicapp.service.impl;

import com.vetclinicapp.model.entity.Role;
import com.vetclinicapp.model.entity.User;
import com.vetclinicapp.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
                .map(VetClinicAppUserDetailsService::map)
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found!"));

    }



    private static UserDetails map(User user){
      return   org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities(user.getRoles().stream().map(VetClinicAppUserDetailsService::map).toList())
                .build();

    }

    private  static GrantedAuthority map(Role role){
// add authorities

        return new SimpleGrantedAuthority("ROLE_" + role.getRoleName().name());


    }
}
