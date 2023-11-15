package com.vetclinicapp.service;

import com.vetclinicapp.model.dto.OwnerRegisterBindingModel;
import com.vetclinicapp.model.service.OwnerServiceModel;

public interface OwnerService {
    boolean registerOwner(OwnerServiceModel ownerServiceModel);

}
