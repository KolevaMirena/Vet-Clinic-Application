package com.vetclinicapp.controller;


import com.vetclinicapp.model.dto.UserRegisterBindingModel;
import com.vetclinicapp.model.service.UserServiceModel;
import com.vetclinicapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;

@Controller
public class UserController {


    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
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


}
