package com.vetclinicapp.repository;

import com.vetclinicapp.model.entity.PetManipulation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetManipulationRepository extends JpaRepository<PetManipulation, Long> {


    List<PetManipulation> getPetManipulationsByPetNameOrderByManipulationDateDesc(String name);



}
