package com.vetclinicapp.service.impl;


import com.vetclinicapp.model.entity.Owner;
import com.vetclinicapp.model.service.OwnerServiceModel;
import com.vetclinicapp.repository.ManipulationTypeRepository;
import com.vetclinicapp.repository.OwnerRepository;
import com.vetclinicapp.service.ManipulationTypeService;
import com.vetclinicapp.service.OwnerService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OwnerServiceImplTest {

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private OwnerRepository ownerRepository;

    @BeforeEach
    public void  setUp(){
        ownerRepository.deleteAll();
    }

    @AfterEach
    public void  tearDown(){
        ownerRepository.deleteAll();
    }

    @Test
    public void ownerRegisterTest(){

        //OwnerServiceModel newOwner = new OwnerServiceModel();
        //newOwner.setName("Mira");
        //newOwner.setPhone("88888888888");
//
        //ownerService.registerOwner(newOwner);
//
        //Owner ownerByPhone = ownerRepository.findOwnerByPhone("88888888888");
//
        //assertEquals(1, ownerRepository.count());
        //assertNotNull(ownerByPhone);

    }
}
