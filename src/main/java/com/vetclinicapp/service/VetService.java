package com.vetclinicapp.service;

import com.vetclinicapp.model.dto.VetAssignBindingModel;
import com.vetclinicapp.model.dto.VetRegisterBindingModel;
import com.vetclinicapp.model.entity.Vet;
import com.vetclinicapp.model.service.VetServiceModel;

import java.util.List;

public interface VetService {
    boolean registerVet(VetServiceModel vetServiceModel);

    boolean assignVet(VetAssignBindingModel vetAssignBindingModel);

    List<Vet> getAllVets();
}
