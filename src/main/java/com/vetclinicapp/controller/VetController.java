package com.vetclinicapp.controller;


import com.vetclinicapp.model.dto.VetAssignBindingModel;
import com.vetclinicapp.model.dto.VetRegisterBindingModel;
import com.vetclinicapp.model.entity.Pet;
import com.vetclinicapp.model.entity.Vet;
import com.vetclinicapp.model.service.VetServiceModel;
import com.vetclinicapp.service.PetService;
import com.vetclinicapp.service.VetService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class VetController {


    private final VetService vetService;
    private final PetService petService;

    private final ModelMapper modelMapper;


    public VetController(VetService vetService, PetService petService, ModelMapper modelMapper) {
        this.vetService = vetService;
        this.petService = petService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/vet/add")
    public ModelAndView registerVet(@ModelAttribute("vetRegisterBindingModel") VetRegisterBindingModel vetRegisterBindingModel) {
        return new ModelAndView("vet-add");
    }


    @PostMapping("/vet/add")
    public ModelAndView registerVet(@ModelAttribute("vetRegisterBindingModel") @Valid VetRegisterBindingModel vetRegisterBindingModel,
                                                        BindingResult bindingResult) {


        if(bindingResult.hasErrors()){
            return new ModelAndView("vet-add");

        }

        boolean successfulRegister = vetService.registerVet(modelMapper.map(vetRegisterBindingModel, VetServiceModel.class));

        if(!successfulRegister){
            ModelAndView modelAndView = new ModelAndView("vet-add");
            modelAndView.addObject("hasVetRegistrationError", true);
            return modelAndView;
        }


        return new ModelAndView("redirect:/home");
    }


    @GetMapping("/vet/assign")
    public ModelAndView registerVet(@ModelAttribute("vetAssignBindingModel") VetAssignBindingModel vetAssignBindingModel){

        ModelAndView modelAndView = new ModelAndView("vet-assign");

        List<Pet> unassignedPets = this.petService.unassignedPets();
        List<Vet> allVets = this.vetService.getAllVets();

        modelAndView.addObject("unassignedPets", unassignedPets);
        modelAndView.addObject("allVets", allVets);


        return modelAndView;
    }


    @PostMapping("/vet/assign")
    public ModelAndView registerVet(@ModelAttribute("vetAssignBindingModel") @Valid VetAssignBindingModel vetAssignBindingModel,
                                    BindingResult bindingResult) {



        if(bindingResult.hasErrors() || vetAssignBindingModel.getPetName() == null || vetAssignBindingModel.getVetName() == null){
            return new ModelAndView("vet-assign");

        }


        boolean successfulAssigned = vetService.assignVet(vetAssignBindingModel);


        if(!successfulAssigned){
            ModelAndView modelAndView = new ModelAndView("vet-assign");
            modelAndView.addObject("hasVetAssignError", true);
            return modelAndView;
        }



        return new ModelAndView("redirect:/home");
    }

}
