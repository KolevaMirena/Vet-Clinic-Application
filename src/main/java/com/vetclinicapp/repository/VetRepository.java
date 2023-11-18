package com.vetclinicapp.repository;


import com.vetclinicapp.model.entity.Vet;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VetRepository extends JpaRepository<Vet, Long> {
    boolean existsByFirstNameAndLastName(String firstName, String lastName);

    List<Vet> findAll();

    Vet findByLastName(String lastNme);

    List<Vet> findAllByOrderByFirstName();

}
