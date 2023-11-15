package com.vetclinicapp.service;


import com.vetclinicapp.model.dto.UserLoginBindingModel;
import com.vetclinicapp.model.dto.UserRegisterBindingModel;
import com.vetclinicapp.model.service.UserServiceModel;

public interface UserService {
    boolean register(UserServiceModel userServiceModel);

    boolean login(UserLoginBindingModel userLoginBindingModel);

    void logout();
}
