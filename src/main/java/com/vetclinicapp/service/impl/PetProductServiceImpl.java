package com.vetclinicapp.service.impl;


import com.vetclinicapp.model.view.PetProductViewModel;
import com.vetclinicapp.repository.PetProductRepository;
import com.vetclinicapp.service.PetProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetProductServiceImpl implements PetProductService {

    private final PetProductRepository petProductRepository;
    private final ModelMapper modelMapper;

    public PetProductServiceImpl(PetProductRepository petProductRepository, ModelMapper modelMapper) {
        this.petProductRepository = petProductRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PetProductViewModel> getAllPetProducts(String name){
        return this.petProductRepository.getPetProductsByPetName(name)
                .stream()
                .map(petProduct -> modelMapper.map(petProduct, PetProductViewModel.class))
                .collect(Collectors.toList());
    }
}
