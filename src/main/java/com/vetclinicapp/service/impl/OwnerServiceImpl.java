package com.vetclinicapp.service.impl;


import com.vetclinicapp.model.entity.Owner;
import com.vetclinicapp.model.service.OwnerServiceModel;
import com.vetclinicapp.repository.OwnerRepository;
import com.vetclinicapp.service.OwnerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final ModelMapper modelMapper;

    public OwnerServiceImpl(OwnerRepository ownerRepository, ModelMapper modelMapper) {
        this.ownerRepository = ownerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean registerOwner(OwnerServiceModel ownerServiceModel) {

        Owner owner = modelMapper.map(ownerServiceModel, Owner.class);

        this.ownerRepository.save(owner);

        return true;
    }
}
