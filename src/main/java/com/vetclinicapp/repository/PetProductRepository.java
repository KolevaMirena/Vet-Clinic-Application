package com.vetclinicapp.repository;


import com.vetclinicapp.model.entity.PetProduct;
import com.vetclinicapp.model.view.PetProductViewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetProductRepository extends JpaRepository<PetProduct, Long> {


     PetProduct findByPetNameAndProductName(String petName, String productName);

     List<PetProduct> getPetProductsByPetName(String name);


     List<PetProduct> findByPetName(String name);
}
