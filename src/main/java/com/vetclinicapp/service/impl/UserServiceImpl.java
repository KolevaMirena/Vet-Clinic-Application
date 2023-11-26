package com.vetclinicapp.service.impl;

import com.vetclinicapp.model.entity.Role;
import com.vetclinicapp.model.entity.User;
import com.vetclinicapp.model.enums.UserRoleEnum;
import com.vetclinicapp.model.service.UserServiceModel;
import com.vetclinicapp.repository.RoleRepository;
import com.vetclinicapp.repository.UserRepository;
import com.vetclinicapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public  class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final ModelMapper modelMapper;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder,  ModelMapper modelMapper, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

        this.modelMapper = modelMapper;
        this.roleRepository = roleRepository;
    }

   @Override
    public boolean register(UserServiceModel userServiceModel) {

        User user = modelMapper.map(userServiceModel,User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));


       Role adminRole = this.roleRepository.findRoleByRoleName(UserRoleEnum.ADMIN);
       Role userRole =this.roleRepository.findRoleByRoleName(UserRoleEnum.USER);


        this.userRepository.save(user);


        return true;
    }



}
