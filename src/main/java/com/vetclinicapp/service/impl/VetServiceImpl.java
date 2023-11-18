package com.vetclinicapp.service.impl;

import com.vetclinicapp.model.dto.VetAssignBindingModel;
import com.vetclinicapp.model.entity.Pet;
import com.vetclinicapp.model.entity.Vet;
import com.vetclinicapp.model.service.VetServiceModel;
import com.vetclinicapp.repository.PetRepository;
import com.vetclinicapp.repository.VetRepository;
import com.vetclinicapp.service.VetService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VetServiceImpl implements VetService {

    private final VetRepository vetRepository;
    private final PetRepository petRepository;

    private final ModelMapper modelMapper;
    public VetServiceImpl(VetRepository vetRepository, PetRepository petRepository, ModelMapper modelMapper) {
        this.vetRepository = vetRepository;
        this.petRepository = petRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean registerVet(VetServiceModel vetServiceModel) {


        Vet vet = modelMapper.map(vetServiceModel, Vet.class);

            this.vetRepository.save(vet);
            return true;
    }

    @Override
    public boolean assignVet(VetAssignBindingModel vetAssignBindingModel) {

        Pet currentPet = this.petRepository.findByName(vetAssignBindingModel.getPetName());

        Vet currentVet = this.vetRepository.findByLastName(vetAssignBindingModel.getVetName());

        currentPet.setVet(currentVet);
        currentVet.getPets().add(currentPet);

        this.petRepository.save(currentPet);

        return true;
    }

    @Override
    public List<Vet> getAllVets() {
        return this.vetRepository.findAll();
    }
}
