package com.vetclinicapp.controller;


import com.vetclinicapp.model.dto.RoleAddBindingModel;
import com.vetclinicapp.model.dto.UserRegisterBindingModel;
import com.vetclinicapp.model.dto.UserRoleBindingModel;
import com.vetclinicapp.model.entity.Role;
import com.vetclinicapp.model.entity.User;
import com.vetclinicapp.model.service.UserServiceModel;
import com.vetclinicapp.model.view.UserRoleViewModel;
import com.vetclinicapp.model.view.UserViewModel;
import com.vetclinicapp.service.RoleService;
import com.vetclinicapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;

import java.util.List;

@Controller
public class UserController {


    private final UserService userService;
    private final ModelMapper modelMapper;
    private final RoleService roleService;

    public UserController(UserService userService, ModelMapper modelMapper, RoleService roleService) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.roleService = roleService;
    }

    @GetMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }


    @GetMapping("/register")
    public ModelAndView register(@ModelAttribute("userRegisterBindingModel") UserRegisterBindingModel userRegisterBindingModel){
        return new ModelAndView("register");
    }


    @PostMapping("/register")
    public ModelAndView register(@ModelAttribute ("userRegisterBindingModel") @Valid UserRegisterBindingModel userRegisterBindingModel,
                                                                BindingResult bindingResult){

        if(bindingResult.hasErrors() || !userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())){
            return new ModelAndView("register");

        }

        boolean successfulRegister = userService.register(modelMapper.map(userRegisterBindingModel, UserServiceModel.class));


        if(!successfulRegister){
            ModelAndView modelAndView = new ModelAndView("register");
            modelAndView.addObject("hasRegistrationError", true);
            return modelAndView;
        }

        return new ModelAndView("redirect:/login");

    }

    @GetMapping("/users/all")
    public ModelAndView allUsers(){

        ModelAndView modelAndView = new ModelAndView("users-all");

        List<UserViewModel> allUsersOrderByName = this.userService.getAllUsersOrderByName();
        List<Role> allRoles = this.roleService.getAllRoles();


        modelAndView.addObject("allRoles", allRoles);
        modelAndView.addObject("allUsersOrderByName", allUsersOrderByName);

        return modelAndView;
    }


  // @GetMapping("/user/roles/{id}")
  // public ModelAndView userRoles(@PathVariable("id") Long id, @ModelAttribute ("userRegisterBindingModel") UserRoleBindingModel userRoleBindingModel){

  //     ModelAndView modelAndView = new ModelAndView("user-roles");

  //     User currentUser = this.userService.findUserById(id);
  //     List<Role> allRoles = this.roleService.getAllRoles();

  //     modelAndView.addObject("allRoles", allRoles);
  //     modelAndView.addObject("currentUser", currentUser);

  //     return modelAndView;
  // }


//   @GetMapping("/user/{userId}/addRole/{roleId}")
//   public ModelAndView userAddRole(@PathVariable("userId") Long userId, @PathVariable("roleId") Long roleId, UserRoleBindingModel userRoleBindingModel,
//                                   BindingResult bindingResult){

//       this.userService.addUserRole(userId, roleId);

//       return new ModelAndView("users-all");
//   }

    @GetMapping("/user/addRole")
  public ModelAndView userAddRole(@ModelAttribute("userRoleBindingModel") UserRoleBindingModel userRoleBindingModel){

       ModelAndView modelAndView = new ModelAndView("role-add");
       List<UserViewModel> allUsersOrderByName = this.userService.getAllUsersOrderByName();
       List<Role> allRoles = this.roleService.getAllRoles();

       modelAndView.addObject("allUsersOrderByName", allUsersOrderByName);
       modelAndView.addObject("allRoles", allRoles);


       return modelAndView;
  }

    @PostMapping("/user/addRole")
    public ModelAndView userAddRole( @ModelAttribute("userRoleBindingModel") @Valid UserRoleBindingModel userRoleBindingModel,
                                     BindingResult bindingResult){


        if(bindingResult.hasErrors()){
            return new ModelAndView("role-add");

        }

        boolean successfulAddedRole = userService.addUserRole(userRoleBindingModel);

        if(!successfulAddedRole){
            ModelAndView modelAndView = new ModelAndView("role-add");
            modelAndView.addObject("hasAddRoleError", true);
            return modelAndView;
        }

        return new ModelAndView("redirect:/home");
    }




}
