package com.vetclinicapp.controller;


import com.vetclinicapp.model.dto.OwnerRegisterBindingModel;
import com.vetclinicapp.model.service.OwnerServiceModel;
import com.vetclinicapp.service.OwnerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class OwnerController {



    private final OwnerService ownerService;
    private final ModelMapper modelMapper;

    public OwnerController(OwnerService ownerService, ModelMapper modelMapper) {
        this.ownerService = ownerService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/owner/add")
    public ModelAndView registerOwner(@ModelAttribute("ownerRegisterBindingModel") OwnerRegisterBindingModel ownerRegisterBindingModel) {
        return new ModelAndView("owner-add");
    }


    @PostMapping("/owner/add")
    public ModelAndView registerOwner(@ModelAttribute("ownerRegisterBindingModel") @Valid OwnerRegisterBindingModel ownerRegisterBindingModel,
                                    BindingResult bindingResult) {



        if(bindingResult.hasErrors()){
            return new ModelAndView("owner-add");

        }

        boolean successfulRegister = ownerService.registerOwner(modelMapper.map(ownerRegisterBindingModel, OwnerServiceModel.class));

        if(!successfulRegister){
            ModelAndView modelAndView = new ModelAndView("owner-add");
            modelAndView.addObject("hasOwnerRegistrationError", true);
            return modelAndView;
        }


        return new ModelAndView("redirect:/home");
    }


}
