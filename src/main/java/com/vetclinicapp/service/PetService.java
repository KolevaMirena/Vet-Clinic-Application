package com.vetclinicapp.service;

import com.vetclinicapp.model.dto.PetManipulationBindingModel;
import com.vetclinicapp.model.dto.PetRegisterBindingModel;
import com.vetclinicapp.model.entity.Pet;
import com.vetclinicapp.model.service.PetServiceModel;
import com.vetclinicapp.model.view.PetViewModel;

import java.util.List;

public interface PetService {
    boolean registerPet(PetServiceModel petServiceModel, PetRegisterBindingModel petRegisterBindingModel);

    List<Pet> unassignedPets();

    boolean execute(PetManipulationBindingModel petManipulationBindingModel);

    List<Pet> getAllPets();

    List<PetViewModel> getAllPetsOrderByName();

    void remove(Long id);

}
