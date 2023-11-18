package com.vetclinicapp.service;

import com.vetclinicapp.model.view.PetManipulationViewModel;

import java.util.List;

public interface PetManipulationService {


    List<PetManipulationViewModel> getPetManipulations(String name);

}
