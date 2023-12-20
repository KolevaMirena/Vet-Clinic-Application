package com.vetclinicapp.service.impl;


import com.vetclinicapp.model.dto.PetRegisterBindingModel;
import com.vetclinicapp.model.dto.VetAssignBindingModel;
import com.vetclinicapp.model.entity.Pet;
import com.vetclinicapp.model.entity.Vet;
import com.vetclinicapp.model.enums.PetTypeEnum;
import com.vetclinicapp.model.enums.VetSpecialtyEnum;
import com.vetclinicapp.model.service.OwnerServiceModel;
import com.vetclinicapp.model.service.PetServiceModel;
import com.vetclinicapp.model.service.VetServiceModel;
import com.vetclinicapp.repository.OwnerRepository;
import com.vetclinicapp.repository.PetRepository;
import com.vetclinicapp.repository.VetRepository;
import com.vetclinicapp.service.OwnerService;
import com.vetclinicapp.service.PetService;
import com.vetclinicapp.service.VetService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class VatServiceImplTest {


    @Autowired
    private VetService vetService;

    @Autowired
    private VetRepository vetRepository;


    @BeforeEach
    public void  setUp(){
        vetRepository.deleteAll();


    }

    @AfterEach
    public void  tearDown(){
        vetRepository.deleteAll();

    }

    @Test
    public void getAllProductsEmptyTest(){

        assertEquals(0, vetRepository.count());

    }

    @Test
    public void vetRegisterTest(){

        VetServiceModel newVet = new VetServiceModel();
        newVet.setFirstName("George");
        newVet.setLastName("Georgiev");
        newVet.setSpecialtyEnum(VetSpecialtyEnum.EXOTIC_ANIMAL_VET);

        vetService.registerVet(newVet);

        assertEquals(1, vetRepository.count());


    }

}
