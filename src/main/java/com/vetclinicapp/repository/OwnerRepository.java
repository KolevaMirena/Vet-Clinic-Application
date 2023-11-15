package com.vetclinicapp.repository;


import com.vetclinicapp.model.entity.Owner;
import com.vetclinicapp.service.OwnerService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {


    Owner findOwnerByPhone(String ownerPhone);
}
