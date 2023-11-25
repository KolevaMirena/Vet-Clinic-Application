package com.vetclinicapp.controller;
import com.vetclinicapp.model.dto.ManipulationAddBindingModel;
import com.vetclinicapp.model.service.ManipulationServiceModel;
import com.vetclinicapp.service.ManipulationService;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;


@Controller
public class ManipulationController {

    private  final ManipulationService manipulationService;
    private final ModelMapper modelMapper;

    public ManipulationController(ManipulationService manipulationService, ModelMapper modelMapper) {
        this.manipulationService = manipulationService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/manipulation/add")
    public ModelAndView addManipulation(@ModelAttribute("manipulationAddBindingModel") ManipulationAddBindingModel manipulationAddBindingModel) {
        return new ModelAndView("manipulation-add");
    }


    @PostMapping("/manipulation/add")
    public ModelAndView addManipulation(@ModelAttribute("manipulationAddBindingModel") @Valid ManipulationAddBindingModel manipulationAddBindingModel,
                                    BindingResult bindingResult) {



        if(bindingResult.hasErrors()){
            return new ModelAndView("manipulation-add");

        }

        boolean successfulAdded = this.manipulationService.addManipulation(modelMapper.map(manipulationAddBindingModel, ManipulationServiceModel.class));

        if(!successfulAdded){
            ModelAndView modelAndView = new ModelAndView("manipulation-add");
            modelAndView.addObject("hasManipulationAddError", true);
            return modelAndView;
        }


        return new ModelAndView("redirect:/home");
    }


}
