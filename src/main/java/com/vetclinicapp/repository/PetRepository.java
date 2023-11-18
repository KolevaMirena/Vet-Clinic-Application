package com.vetclinicapp.repository;


import com.vetclinicapp.model.entity.Pet;
import com.vetclinicapp.model.view.PetViewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    boolean existsPetByName(String name);


   @Query(nativeQuery = true, value = "SELECT * FROM pets where vet_id is null")
    List<Pet> getAllNonAssignPets();

   Pet findByName(String name);

   List<Pet> findAll();


    @Query(nativeQuery = true, value = "SELECT * FROM pets order by name")
   List<Pet> findAllByOrderByName();

    List<Pet> findAllByVetId(Long id);

    List<Pet> findAllByOwnerId(Long id);
}
