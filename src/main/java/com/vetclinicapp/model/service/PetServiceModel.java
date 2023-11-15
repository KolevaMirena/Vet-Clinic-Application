package com.vetclinicapp.model.service;

import com.vetclinicapp.model.entity.Manipulation;
import com.vetclinicapp.model.entity.Owner;
import com.vetclinicapp.model.entity.Product;
import com.vetclinicapp.model.entity.Vet;
import com.vetclinicapp.model.enums.PetTypeEnum;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PetServiceModel {


    private String name;
    private Long age;
    private PetTypeEnum petType;
    private Owner owner;
    private Vet vet;
    private LocalDate lastManipulationDate;


    public PetServiceModel() {
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

    public PetTypeEnum getPetType() {
        return petType;
    }

    public void setPetType(PetTypeEnum petType) {
        this.petType = petType;
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


    public LocalDate getLastManipulationDate() {
        return lastManipulationDate;
    }

    public void setLastManipulationDate(LocalDate lastManipulationDate) {
        this.lastManipulationDate = lastManipulationDate;
    }

}

