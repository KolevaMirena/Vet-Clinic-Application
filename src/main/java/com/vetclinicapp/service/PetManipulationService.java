package com.vetclinicapp.service;

import com.vetclinicapp.model.view.PetManipulationViewModel;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface PetManipulationService {


  List<PetManipulationViewModel> getPetManipulations(String name);

}
