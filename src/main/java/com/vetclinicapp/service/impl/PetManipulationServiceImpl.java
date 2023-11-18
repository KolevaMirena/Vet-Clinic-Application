package com.vetclinicapp.service.impl;

import com.vetclinicapp.model.view.PetManipulationViewModel;
import com.vetclinicapp.repository.PetManipulationRepository;
import com.vetclinicapp.service.PetManipulationService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetManipulationServiceImpl implements PetManipulationService {

    private final PetManipulationRepository petManipulationRepository;
    private final ModelMapper modelMapper;

    public PetManipulationServiceImpl(PetManipulationRepository petManipulationRepository, ModelMapper modelMapper) {
        this.petManipulationRepository = petManipulationRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<PetManipulationViewModel> getPetManipulations(String name) {

        return this.petManipulationRepository.getPetManipulationsByPetNameOrderByManipulationDateDesc(name)
                .stream()
                .map(petManipulation -> modelMapper.map(petManipulation, PetManipulationViewModel.class))
                .collect(Collectors.toList());


    }
}
