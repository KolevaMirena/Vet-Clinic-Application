package com.vetclinicapp.service.impl;

import com.vetclinicapp.model.dto.VetAssignBindingModel;
import com.vetclinicapp.model.entity.Pet;
import com.vetclinicapp.model.entity.Vet;
import com.vetclinicapp.model.service.VetServiceModel;
import com.vetclinicapp.model.view.VetViewModel;
import com.vetclinicapp.repository.PetRepository;
import com.vetclinicapp.repository.VetRepository;
import com.vetclinicapp.service.VetService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


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
        this.vetRepository.save(currentVet);

        return true;
    }

    @Override
    public List<Vet> getAllVets() {
        return this.vetRepository.findAll();
    }

    @Override
    public List<VetViewModel> getAllVetsOrderByName() {
        return this.vetRepository.findAllByOrderByFirstName()
                .stream()
                .map(vet -> modelMapper.map(vet, VetViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void remove(Long id) {
        //todo
        //make all vet's patients unassigned

        List<Pet> allByVetId = this.petRepository.findAllByVetId(id);

        for (Pet pet : allByVetId) {
            pet.setVet(null);
            this.petRepository.save(pet);
        }

        this.vetRepository.deleteById(id);

    }
}
