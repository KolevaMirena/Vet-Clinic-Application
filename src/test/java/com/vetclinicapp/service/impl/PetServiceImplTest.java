package com.vetclinicapp.service.impl;


import com.sun.jdi.LongValue;
import com.vetclinicapp.model.dto.PetRegisterBindingModel;
import com.vetclinicapp.model.entity.Owner;
import com.vetclinicapp.model.entity.Pet;
import com.vetclinicapp.model.enums.PetTypeEnum;
import com.vetclinicapp.model.service.OwnerServiceModel;
import com.vetclinicapp.model.service.PetServiceModel;
import com.vetclinicapp.repository.OwnerRepository;
import com.vetclinicapp.repository.PetRepository;
import com.vetclinicapp.service.OwnerService;
import com.vetclinicapp.service.PetService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.parameters.P;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class PetServiceImplTest {

    @Autowired
    private PetService petService;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private OwnerService ownerService;
    @Autowired
    OwnerRepository ownerRepository;

    @BeforeEach
    public void  setUp(){
        petRepository.deleteAll();
        ownerRepository.deleteAll();
    }

    @AfterEach
    public void  tearDown(){
        petRepository.deleteAll();
        ownerRepository.deleteAll();
    }

    @Test
    public void petRegisterTest(){

        OwnerServiceModel owner = new OwnerServiceModel();
        owner.setName("Mira");
        owner.setPhone("0898718879");

        ownerService.registerOwner(owner);

        PetServiceModel newPet = new PetServiceModel();
        newPet.setName("Kari");
        newPet.setPetType(PetTypeEnum.DOG);
        newPet.setAge(1L);

        PetRegisterBindingModel petRegisterBindingModel = new PetRegisterBindingModel();
        petRegisterBindingModel.setName("Kari");
        petRegisterBindingModel.setPetType(PetTypeEnum.DOG);
        petRegisterBindingModel.setAge(1L);
        petRegisterBindingModel.setOwnerPhone("0898718879");

        petService.registerPet(newPet, petRegisterBindingModel);

        assertEquals(1, petRepository.count());


    }

    @Test
    public void getAllPetsTest(){

        OwnerServiceModel owner = new OwnerServiceModel();
        owner.setName("Mira");
        owner.setPhone("0898718879");

        ownerService.registerOwner(owner);

        PetServiceModel newPet = new PetServiceModel();
        newPet.setName("Kari");
        newPet.setPetType(PetTypeEnum.DOG);
        newPet.setAge(1L);

        PetRegisterBindingModel petRegisterBindingModel = new PetRegisterBindingModel();
        petRegisterBindingModel.setName("Kari");
        petRegisterBindingModel.setPetType(PetTypeEnum.DOG);
        petRegisterBindingModel.setAge(1L);
        petRegisterBindingModel.setOwnerPhone("0898718879");

        petService.registerPet(newPet, petRegisterBindingModel);

        PetServiceModel newPet2 = new PetServiceModel();
        newPet2.setName("Max");
        newPet2.setPetType(PetTypeEnum.CAT);
        newPet2.setAge(1L);

        PetRegisterBindingModel petRegisterBindingModel2 = new PetRegisterBindingModel();
        petRegisterBindingModel2.setName("Max");
        petRegisterBindingModel2.setPetType(PetTypeEnum.CAT);
        petRegisterBindingModel2.setAge(1L);
        petRegisterBindingModel2.setOwnerPhone("0898718879");

        petService.registerPet(newPet2, petRegisterBindingModel2);

        List<Pet> allPets = petService.getAllPets();

        assertEquals(2, allPets.size());


    }
}
