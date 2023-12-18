package com.vetclinicapp.service.impl;
import com.vetclinicapp.model.dto.ManipulationAddBindingModel;
import com.vetclinicapp.model.entity.Manipulation;
import com.vetclinicapp.model.enums.ManipulationTypeEnum;
import com.vetclinicapp.model.service.ManipulationServiceModel;
import com.vetclinicapp.repository.ManipulationRepository;
import com.vetclinicapp.service.ManipulationService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class ManipulationServiceImplTest {


    @Autowired
    private ManipulationService manipulationServiceToTest;

    @Autowired
    private ManipulationRepository manipulationRepository;

    @BeforeEach
    public void  setUp(){
        manipulationRepository.deleteAll();
    }

    @AfterEach
    public void  tearDown(){
        manipulationRepository.deleteAll();
    }

    @Test
    public void addManipulationTest(){

        ManipulationServiceModel newManipulation = new ManipulationServiceModel();
        newManipulation.setName("testManipulation");
        newManipulation.setDescription("testDescription");
        newManipulation.setPrice(BigDecimal.valueOf(50));
        newManipulation.setType(ManipulationTypeEnum.MANDATORY);

        manipulationServiceToTest.addManipulation(newManipulation);

        Manipulation testManipulation = manipulationRepository.findByName("testManipulation");

        assertNotNull(testManipulation);
        assertEquals(1, manipulationRepository.count());

    }

    @Test
    public void getAllTest(){

        ManipulationServiceModel newManipulation = new ManipulationServiceModel();
        newManipulation.setName("testManipulation");
        newManipulation.setDescription("testDescription");
        newManipulation.setPrice(BigDecimal.valueOf(50));
        newManipulation.setType(ManipulationTypeEnum.MANDATORY);

        manipulationServiceToTest.addManipulation(newManipulation);

        List<Manipulation> all = manipulationRepository.findAll();

        assertFalse(all.isEmpty());

        assertEquals(1, all.size());


    }





}
