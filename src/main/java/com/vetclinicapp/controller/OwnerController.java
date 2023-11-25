package com.vetclinicapp.controller;


import com.vetclinicapp.model.dto.OwnerRegisterBindingModel;
import com.vetclinicapp.model.service.OwnerServiceModel;
import com.vetclinicapp.model.view.PetViewModel;
import com.vetclinicapp.service.OwnerService;
import com.vetclinicapp.service.PetService;
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
public class OwnerController {



    private final OwnerService ownerService;
    private final ModelMapper modelMapper;
    private final PetService petService;

    public OwnerController(OwnerService ownerService, ModelMapper modelMapper, PetService petService) {
        this.ownerService = ownerService;
        this.modelMapper = modelMapper;
        this.petService = petService;
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

    @PostMapping ("/owner/remove/{id}")
    public ModelAndView removeOwner(@PathVariable("id") Long id){

        this.ownerService.remove(id);

        return new ModelAndView("redirect:/home");

    }


    @GetMapping ("/owner/pets/{id}")
    public ModelAndView OwnerPets(@PathVariable("id") Long id){

        ModelAndView modelAndView = new ModelAndView("pets-all-by-owner");

        List<PetViewModel> allPetsByOwnerId = this.petService.getAllPetsByOwnerId(id);

        modelAndView.addObject("allPetsByOwnerId", allPetsByOwnerId);

        return modelAndView;

    }


}
