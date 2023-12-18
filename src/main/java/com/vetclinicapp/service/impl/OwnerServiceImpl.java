package com.vetclinicapp.service.impl;


import com.vetclinicapp.model.entity.*;
import com.vetclinicapp.model.service.OwnerServiceModel;
import com.vetclinicapp.model.view.OwnerViewModel;
import com.vetclinicapp.repository.*;
import com.vetclinicapp.service.OwnerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final ModelMapper modelMapper;
    private final PetProductRepository petProductRepository;

    private final PetManipulationRepository petManipulationRepository;
    private final VetRepository vetRepository;
    private final PetRepository petRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository, ModelMapper modelMapper, PetProductRepository petProductRepository, PetManipulationRepository petManipulationRepository, VetRepository vetRepository, PetRepository petRepository) {
        this.ownerRepository = ownerRepository;
        this.modelMapper = modelMapper;
        this.petProductRepository = petProductRepository;
        this.petManipulationRepository = petManipulationRepository;
        this.vetRepository = vetRepository;
        this.petRepository = petRepository;
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


        //todo
        //find all owners pets
        Owner ownerById = this.ownerRepository.findOwnerById(id);
        if (ownerById != null) {
            Set<Pet> currentOwnerPets = ownerById.getPets();

            //remove pets from:
            //vets collections

            if (!currentOwnerPets.isEmpty()) {
                for (Pet currentOwnerPet : currentOwnerPets) {

                    Vet currentVet = currentOwnerPet.getVet();
                    if (currentVet != null) {
                        currentVet.getPets().remove(currentOwnerPet);
                        this.vetRepository.save(currentVet);
                    }


                    List<PetProduct> currentPetProduct = this.petProductRepository.findByPetName(currentOwnerPet.getName());
                    if (!currentPetProduct.isEmpty()) {
                        this.petProductRepository.deleteAll(currentPetProduct);
                    }


                    List<PetManipulation> currentPetManipulation = this.petManipulationRepository.findAllByPetName(currentOwnerPet.getName());
                    if (!currentPetManipulation.isEmpty()) {
                        this.petManipulationRepository.deleteAll(currentPetManipulation);
                    }


                }

                this.petRepository.deleteAll(currentOwnerPets);
            }

            //remove owner
            this.ownerRepository.deleteById(id);
        }
    }
}
