package com.vetclinicapp.service.impl;

import com.vetclinicapp.model.dto.PetManipulationBindingModel;
import com.vetclinicapp.model.dto.PetRegisterBindingModel;
import com.vetclinicapp.model.entity.*;
import com.vetclinicapp.model.service.PetServiceModel;
import com.vetclinicapp.model.view.PetViewModel;
import com.vetclinicapp.repository.*;
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
    private final PetProductRepository petProductRepository;
    private final VetRepository vetRepository;





    public PetServiceImpl(PetRepository petRepository, OwnerRepository ownerRepository, ModelMapper modelMapper, ManipulationRepository manipulationRepository, PetManipulationRepository petManipulationRepository, PetManipulationRepository petManipulationRepository1, PetProductRepository petProductRepository, VetRepository vetRepository) {
        this.petRepository = petRepository;
        this.ownerRepository = ownerRepository;
        this.modelMapper = modelMapper;
        this.petManipulationRepository = petManipulationRepository1;
        this.petProductRepository = petProductRepository;
        this.vetRepository = vetRepository;
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
                    petViewModel.setPetType(pet.getPetType().name());

                    return petViewModel;

                }).collect(Collectors.toList());
    }

    @Override
    public void remove(Long id) {

        // remove from petProduct

        Pet petById = this.petRepository.findPetById(id);
        if(petById!=null) {

            List<PetProduct> currentPetProduct = this.petProductRepository.findByPetName(petById.getName());

            if (!currentPetProduct.isEmpty()) {
                this.petProductRepository.deleteAll(currentPetProduct);
            }


            //remove from petManipulation

            List<PetManipulation> currentPetManipulation = this.petManipulationRepository.findAllByPetName(petById.getName());
            if (!currentPetManipulation.isEmpty()) {
                this.petManipulationRepository.deleteAll(currentPetManipulation);
            }


            //remove from Owner petList

            Owner owner = petById.getOwner();
            Set<Pet> pets = owner.getPets();
            pets.remove(petById);
            this.ownerRepository.save(owner);

            //remove from vet petList


            Vet vet = petById.getVet();
            if (vet != null) {
                List<Pet> vetPets = vet.getPets();
                vetPets.remove(petById);
                this.vetRepository.save(vet);
            }


            this.petRepository.deleteById(id);
        }

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
