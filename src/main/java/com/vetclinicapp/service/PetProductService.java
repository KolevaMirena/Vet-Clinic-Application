package com.vetclinicapp.service;

import com.vetclinicapp.model.entity.PetProduct;
import com.vetclinicapp.model.view.PetProductViewModel;

import java.util.List;

public interface PetProductService {
    List<PetProductViewModel> getAllPetProducts(String name);

}
