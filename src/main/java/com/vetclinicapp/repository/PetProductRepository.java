package com.vetclinicapp.repository;


import com.vetclinicapp.model.entity.PetProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetProductRepository extends JpaRepository<PetProduct, Long> {


     PetProduct findByPetNameAndProductName(String petName, String productName);
}
