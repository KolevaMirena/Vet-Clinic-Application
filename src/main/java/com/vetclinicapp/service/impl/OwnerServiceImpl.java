package com.vetclinicapp.service.impl;


import com.vetclinicapp.model.entity.Owner;
import com.vetclinicapp.model.service.OwnerServiceModel;
import com.vetclinicapp.model.view.OwnerViewModel;
import com.vetclinicapp.repository.OwnerRepository;
import com.vetclinicapp.service.OwnerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<OwnerViewModel> getAllOwnersOrderByName() {
        return this.ownerRepository.getOwnersByOrderByName()
                .stream().map(owner -> modelMapper.map(owner, OwnerViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void remove(Long id) {
        this.ownerRepository.deleteById(id);

        //todo
        //remove all owners pets from the db
    }
}
