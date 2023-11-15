package com.vetclinicapp.repository;


import com.vetclinicapp.model.entity.ManipulationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManipulationTypeRepository extends JpaRepository<ManipulationType, Long> {
}
