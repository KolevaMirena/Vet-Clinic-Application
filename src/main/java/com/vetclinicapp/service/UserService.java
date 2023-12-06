package com.vetclinicapp.service;


import com.vetclinicapp.model.dto.UserRoleBindingModel;
import com.vetclinicapp.model.entity.User;
import com.vetclinicapp.model.service.UserServiceModel;
import com.vetclinicapp.model.view.UserRoleViewModel;
import com.vetclinicapp.model.view.UserViewModel;

import java.util.List;

public interface UserService {
    boolean register(UserServiceModel userServiceModel);

    List<UserViewModel> getAllUsersOrderByName();

    List<UserRoleViewModel> getRolesByUserId(Long id);

    User findUserById(Long id);

    boolean addUserRole(UserRoleBindingModel userRoleBindingModel);


    boolean removeUserRole(UserRoleBindingModel userRoleBindingModel);

}
