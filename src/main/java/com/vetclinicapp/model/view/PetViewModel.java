package com.vetclinicapp.model.view;

import com.vetclinicapp.model.entity.Manipulation;
import com.vetclinicapp.model.entity.Owner;
import com.vetclinicapp.model.entity.Product;
import com.vetclinicapp.model.entity.Vet;
import com.vetclinicapp.model.enums.PetTypeEnum;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PetViewModel{

    private Long id;
    private String name;
    private Long age;
    private Owner owner;
    private Vet vet;
    private LocalDate lastManipulationDate;
    private PetTypeEnum petType;


    public PetViewModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public LocalDate getLastManipulationDate() {
        return lastManipulationDate;
    }

    public void setLastManipulationDate(LocalDate lastManipulationDate) {
        this.lastManipulationDate = lastManipulationDate;
    }

    public PetTypeEnum getPetType() {
        return petType;
    }

    public void setPetType(PetTypeEnum petType) {
        this.petType = petType;
    }
}
