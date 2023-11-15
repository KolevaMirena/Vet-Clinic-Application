package com.vetclinicapp.init;


import com.vetclinicapp.service.ManipulationTypeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ManipulationTypeInit implements CommandLineRunner {


    private final ManipulationTypeService manipulationTypeService;

    public ManipulationTypeInit(ManipulationTypeService manipulationTypeService) {
        this.manipulationTypeService = manipulationTypeService;
    }


    @Override
    public void run(String... args) throws Exception {

        this.manipulationTypeService.initManipulationType();


        }


    }

