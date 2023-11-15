package com.vetclinicapp.service.impl;

import com.vetclinicapp.model.entity.ManipulationType;
import com.vetclinicapp.model.enums.ManipulationTypeEnum;
import com.vetclinicapp.repository.ManipulationTypeRepository;
import com.vetclinicapp.service.ManipulationTypeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ManipulationTypeServiceImpl implements ManipulationTypeService {

    private final ManipulationTypeRepository manipulationTypeRepository;

    public ManipulationTypeServiceImpl(ManipulationTypeRepository manipulationTypeRepository) {
        this.manipulationTypeRepository = manipulationTypeRepository;
    }


    @Override
    public void initManipulationType() {
        long count = this.manipulationTypeRepository.count();


        if(count==0){

            List<ManipulationType> types =new ArrayList<>();


            Arrays.stream(ManipulationTypeEnum.values())
                    .forEach(enumName ->{
                        ManipulationType manipulationType =new ManipulationType();

                        manipulationType.setName(enumName);

                        types.add(manipulationType);


                    });


            this.manipulationTypeRepository.saveAll(types);




        }
}

}
