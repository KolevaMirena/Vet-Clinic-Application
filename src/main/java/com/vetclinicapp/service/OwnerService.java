package com.vetclinicapp.service;

import com.vetclinicapp.model.dto.OwnerRegisterBindingModel;
import com.vetclinicapp.model.service.OwnerServiceModel;
import com.vetclinicapp.model.view.OwnerViewModel;

import java.util.List;

public interface OwnerService {
    boolean registerOwner(OwnerServiceModel ownerServiceModel);

    List<OwnerViewModel> getAllOwnersOrderByName();

    void remove(Long id);
}
