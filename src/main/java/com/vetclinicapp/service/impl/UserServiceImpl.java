package com.vetclinicapp.service.impl;

import com.vetclinicapp.model.dto.UserRoleBindingModel;
import com.vetclinicapp.model.entity.Role;
import com.vetclinicapp.model.entity.User;
import com.vetclinicapp.model.enums.UserRoleEnum;
import com.vetclinicapp.model.service.UserServiceModel;
import com.vetclinicapp.model.view.UserRoleViewModel;
import com.vetclinicapp.model.view.UserViewModel;
import com.vetclinicapp.repository.RoleRepository;
import com.vetclinicapp.repository.UserRepository;
import com.vetclinicapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


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

       this.userRepository.save(user);

        return true;
    }

    @Override
    public List<UserViewModel> getAllUsersOrderByName() {

     return    this.userRepository.findAllByOrderByUsername()
                .stream().map(user -> modelMapper.map(user, UserViewModel.class))
                .collect(Collectors.toList());

    }



    @Override
    public List<UserRoleViewModel> getRolesByUserId(Long id) {
        return null;
    }


    @Override
    public User findUserById(Long id) {
        return this.userRepository.findUserById(id);
    }

    @Override
    public boolean addUserRole(UserRoleBindingModel userRoleBindingModel) {

        User currentUser = this.userRepository.findByUsername(userRoleBindingModel.getUsername()).get();
        Role currentRole = this.roleRepository.findRoleByRoleName(userRoleBindingModel.getRole());

        if(currentUser == null || currentRole == null){
            return false;
        }

        Set<Role> currentUserRoles = currentUser.getRoles();

        currentUserRoles.clear();
        currentUserRoles.add(currentRole);
        currentUser.setRoles(currentUserRoles);

        this.userRepository.save(currentUser);

        return true;

    }

    @Override
    public void remove(Long id) {

        this.userRepository.deleteById(id);


    }

    @Override
    public boolean changeUsername(String newName, String name) {

        Optional<User> byUsername = this.userRepository.findByUsername(newName);

        if(byUsername.isPresent()){
            return false;
        }

        User currentUser = this.userRepository.findByUsername(name).get();

        currentUser.setUsername(newName);

        this.userRepository.save(currentUser);

        return true;
    }


}
