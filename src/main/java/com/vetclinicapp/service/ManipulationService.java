package com.vetclinicapp.service;

import com.vetclinicapp.model.dto.ManipulationAddBindingModel;
import com.vetclinicapp.model.entity.Manipulation;
import com.vetclinicapp.model.service.ManipulationServiceModel;

import java.util.List;

public interface ManipulationService {
    boolean addManipulation(ManipulationServiceModel manipulationServiceModel);

    List<Manipulation> getAllManipulations();
}
