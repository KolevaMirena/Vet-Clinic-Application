package com.vetclinicapp.controller;

import com.vetclinicapp.model.dto.PetManipulationBindingModel;
import com.vetclinicapp.model.dto.PetRegisterBindingModel;
import com.vetclinicapp.model.entity.Manipulation;
import com.vetclinicapp.model.entity.Pet;
import com.vetclinicapp.model.service.PetServiceModel;
import com.vetclinicapp.model.view.PetManipulationViewModel;
import com.vetclinicapp.model.view.PetProductViewModel;
import com.vetclinicapp.service.ManipulationService;
import com.vetclinicapp.service.PetManipulationService;
import com.vetclinicapp.service.PetProductService;
import com.vetclinicapp.service.PetService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;
import java.util.List;

@Controller
public class PetController {


    private final PetService petService;
    private final ManipulationService manipulationService;
    private final ModelMapper modelMapper;
    private final PetManipulationService petManipulationService;
    private final PetProductService petProductService;


    public PetController(PetService petService, ManipulationService manipulationService, ModelMapper modelMapper, PetManipulationService petManipulationService, PetProductService petManipulations, PetProductService petProductService) {
        this.petService = petService;
        this.manipulationService = manipulationService;
        this.modelMapper = modelMapper;
        this.petManipulationService = petManipulationService;
        this.petProductService = petProductService;
    }

    @GetMapping("/pet/add")
    public ModelAndView registerPet(@ModelAttribute("petRegisterBindingModel") PetRegisterBindingModel petRegisterBindingModel) {
        return new ModelAndView("pet-add");
    }


    @PostMapping("/pet/add")
    public ModelAndView registerPet(@ModelAttribute("petRegisterBindingModel") @Valid PetRegisterBindingModel petRegisterBindingModel,
                                    BindingResult bindingResult) {



        if(bindingResult.hasErrors()){
            return new ModelAndView("pet-add");

        }

        boolean successfulRegister = petService.registerPet(modelMapper.map(petRegisterBindingModel, PetServiceModel.class), petRegisterBindingModel);

        if(!successfulRegister){
            ModelAndView modelAndView = new ModelAndView("pet-add");
            modelAndView.addObject("hasPetRegistrationError", true);
            return modelAndView;
        }


        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/pet/execute")
    public ModelAndView execute(@ModelAttribute("petManipulationBindingModel") PetManipulationBindingModel petManipulationBindingModel) {

        ModelAndView modelAndView = new ModelAndView("pet-manipulation");


        List<Pet> allPets = this.petService.getAllPets();
        List<Manipulation> manipulationList = this.manipulationService.getAllManipulations();



        modelAndView.addObject("allPets", allPets);
        modelAndView.addObject("manipulationList", manipulationList);


        return modelAndView;
    }


    @PostMapping("/pet/execute")
    public ModelAndView execute(@ModelAttribute("petManipulationBindingModel") @Valid PetManipulationBindingModel petManipulationBindingModel,
                                    BindingResult bindingResult) {



        if(bindingResult.hasErrors()){
            return new ModelAndView("pet-manipulation");

        }

        boolean successfulExecuted = petService.execute(petManipulationBindingModel);

        if(!successfulExecuted){
            ModelAndView modelAndView = new ModelAndView("pet-manipulation");
            modelAndView.addObject("hasPetManipulationError", true);
            return modelAndView;
        }


        return new ModelAndView("redirect:/home");
    }


    @PostMapping ("/pets/remove/{id}")
    public ModelAndView removePet(@PathVariable("id") Long id){

        this.petService.remove(id);

        return new ModelAndView("redirect:/home");

    }

    @GetMapping ("/pet/manipulations/{name}")
    public ModelAndView petManipulations(@PathVariable("name") String name){

        ModelAndView modelAndView = new ModelAndView("pet-all-manipulations");

        List<PetManipulationViewModel> petManipulations = this.petManipulationService.getPetManipulations(name);

        modelAndView.addObject("petManipulations", petManipulations);


        return modelAndView;

    }

    @GetMapping ("/pet/products/{name}")
    public ModelAndView petProducts(@PathVariable("name") String name){

        ModelAndView modelAndView = new ModelAndView("pet-all-products");

        List<PetProductViewModel> allPetProducts = this.petProductService.getAllPetProducts(name);

        modelAndView.addObject("allPetProducts", allPetProducts);

        return modelAndView;

    }

}
