package com.vetclinicapp.service.impl;

import com.vetclinicapp.model.dto.UserLoginBindingModel;
import com.vetclinicapp.model.entity.User;
import com.vetclinicapp.model.service.UserServiceModel;
import com.vetclinicapp.repository.UserRepository;
import com.vetclinicapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public  class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final LoggedUser loggedUser;

    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, LoggedUser loggedUser, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.loggedUser = loggedUser;
        this.modelMapper = modelMapper;
    }

   @Override
    public boolean register(UserServiceModel userServiceModel) {

        User user = modelMapper.map(userServiceModel,User.class);

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        this.userRepository.save(user);

        return true;
    }

    @Override
    public boolean login(UserLoginBindingModel userLoginBindingModel) {

        String username = userLoginBindingModel.getUsername();

        User user = this.userRepository.findByUsername(username);
        if(user != null && passwordEncoder.matches(userLoginBindingModel.getPassword(), user.getPassword())){

            loggedUser.login(username);

            return  true;

        }

            return false;
    }

    @Override
    public void logout() {

        this.loggedUser.logout();

    }

}