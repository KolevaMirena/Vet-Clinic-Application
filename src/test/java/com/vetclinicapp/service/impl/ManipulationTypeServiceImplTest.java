package com.vetclinicapp.service.impl;

import com.vetclinicapp.model.entity.Manipulation;
import com.vetclinicapp.model.enums.ManipulationTypeEnum;
import com.vetclinicapp.model.service.ManipulationServiceModel;
import com.vetclinicapp.repository.ManipulationRepository;
import com.vetclinicapp.repository.ManipulationTypeRepository;
import com.vetclinicapp.service.ManipulationService;
import com.vetclinicapp.service.ManipulationTypeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ManipulationTypeServiceImplTest {


    @Autowired
    private ManipulationTypeService manipulationTypeService;

    @Autowired
    private ManipulationTypeRepository manipulationTypeRepository;

    @BeforeEach
    public void  setUp(){
        manipulationTypeRepository.deleteAll();
    }

    @AfterEach
    public void  tearDown(){
        manipulationTypeRepository.deleteAll();
    }

    @Test
    public void initManipulationTypeTest(){


        manipulationTypeService.initManipulationType();

        assertEquals(2, manipulationTypeRepository.count());



    }



}
