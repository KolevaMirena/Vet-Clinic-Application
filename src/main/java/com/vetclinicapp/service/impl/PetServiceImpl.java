package com.vetclinicapp.service.impl;

import com.vetclinicapp.model.dto.PetManipulationBindingModel;
import com.vetclinicapp.model.dto.PetRegisterBindingModel;
import com.vetclinicapp.model.entity.Owner;
import com.vetclinicapp.model.entity.Pet;
import com.vetclinicapp.model.entity.PetManipulation;
import com.vetclinicapp.model.service.PetServiceModel;
import com.vetclinicapp.model.view.PetManipulationViewModel;
import com.vetclinicapp.model.view.PetViewModel;
import com.vetclinicapp.repository.ManipulationRepository;
import com.vetclinicapp.repository.OwnerRepository;
import com.vetclinicapp.repository.PetManipulationRepository;
import com.vetclinicapp.repository.PetRepository;
import com.vetclinicapp.service.PetService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;
    private final OwnerRepository ownerRepository;

    private final ModelMapper modelMapper;
    private final PetManipulationRepository petManipulationRepository;





    public PetServiceImpl(PetRepository petRepository, OwnerRepository ownerRepository, ModelMapper modelMapper, ManipulationRepository manipulationRepository, PetManipulationRepository petManipulationRepository, PetManipulationRepository petManipulationRepository1) {
        this.petRepository = petRepository;
        this.ownerRepository = ownerRepository;
        this.modelMapper = modelMapper;

        this.petManipulationRepository = petManipulationRepository1;
    }

    @Override
    public boolean registerPet(PetServiceModel petServiceModel, PetRegisterBindingModel petRegisterBindingModel) {


        Owner ownerByPhone = this.ownerRepository.findOwnerByPhone(petRegisterBindingModel.getOwnerPhone());

        if(ownerByPhone == null){
            return  false;
        }


        Pet pet = modelMapper.map(petServiceModel, Pet.class);

        pet.setOwner(ownerByPhone);

        this.petRepository.save(pet);

        Set<Pet> petList = ownerByPhone.getPets();
        petList.add(pet);

        return true;
    }

    @Override
    public List<Pet> unassignedPets() {
        return this.petRepository.getAllNonAssignPets();
    }

    @Override
    public boolean execute(PetManipulationBindingModel petManipulationBindingModel) {

        Pet pet = this.petRepository.findByName(petManipulationBindingModel.getPetName());
        pet.setLastManipulationDate(petManipulationBindingModel.getExecutionDate());
        this.petRepository.save(pet);


        PetManipulation petManipulation = modelMapper.map(petManipulationBindingModel, PetManipulation.class);

        this.petManipulationRepository.save(petManipulation);
        return true;
    }

    @Override
    public List<Pet> getAllPets() {
        return this.petRepository.findAll();
    }

    @Override
    public List<PetViewModel> getAllPetsOrderByName() {

        return  this.petRepository.findAllByOrderByName()
                .stream().map(pet ->{

                    PetViewModel petViewModel = new PetViewModel();

                    petViewModel.setId(pet.getId());
                    petViewModel.setName(pet.getName());
                    petViewModel.setAge(pet.getAge());
                    petViewModel.setOwner(pet.getOwner());
                    petViewModel.setVet(pet.getVet());
                    petViewModel.setLastManipulationDate(pet.getLastManipulationDate());
                    petViewModel.setPetType(pet.getPetType());

                    return petViewModel;

                }).collect(Collectors.toList());
    }

    @Override
    public void remove(Long id) {
        //  TODO
        // remove from petProduct
        //remove from petManipulation
        //remove from Owner petList
        //remove from vet petList
        this.petRepository.deleteById(id);


    }

    @Override
    public List<PetViewModel> getAllPetsByVetId(Long id) {
        return this.petRepository.findAllByVetId(id)
                .stream()
                .map(pet -> modelMapper.map(pet, PetViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PetViewModel> getAllPetsByOwnerId(Long id) {
        return this.petRepository.findAllByOwnerId(id)
                .stream()
                .map(pet -> modelMapper.map(pet, PetViewModel.class))
                .collect(Collectors.toList());
    }

}
