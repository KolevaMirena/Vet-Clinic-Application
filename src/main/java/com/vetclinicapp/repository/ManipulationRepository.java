package com.vetclinicapp.repository;


import com.vetclinicapp.model.entity.Manipulation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManipulationRepository extends JpaRepository<Manipulation, Long> {

    boolean existsManipulationsByName(String name);

    List<Manipulation>  findAll();

    Manipulation findByName(String name);


}
