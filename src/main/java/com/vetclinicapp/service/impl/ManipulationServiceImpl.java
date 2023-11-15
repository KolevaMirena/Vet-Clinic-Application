package com.vetclinicapp.service.impl;

import com.vetclinicapp.model.entity.Manipulation;
import com.vetclinicapp.model.service.ManipulationServiceModel;
import com.vetclinicapp.repository.ManipulationRepository;
import com.vetclinicapp.service.ManipulationService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManipulationServiceImpl implements ManipulationService {

    private final ManipulationRepository manipulationRepository;
    private  final ModelMapper modelMapper;

    public ManipulationServiceImpl(ManipulationRepository manipulationRepository, ModelMapper modelMapper) {
        this.manipulationRepository = manipulationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean addManipulation(ManipulationServiceModel manipulationServiceModel) {

        Manipulation manipulation= modelMapper.map(manipulationServiceModel, Manipulation.class);

        this.manipulationRepository.save(manipulation);

        return true;
    }

    @Override
    public List<Manipulation> getAllManipulations() {
        return this.manipulationRepository.findAll();
    }
}
