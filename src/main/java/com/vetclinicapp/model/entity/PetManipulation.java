package com.vetclinicapp.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "pet_manipulations")
public class PetManipulation extends BaseEntity {

    @Column(nullable = false)
    private String petName;

    @Column(nullable = false)
    private String manipulationName;

    @Column(nullable = false)
    private LocalDate manipulationDate;


    public PetManipulation() {
    }


    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getManipulationName() {
        return manipulationName;
    }

    public void setManipulationName(String manipulationName) {
        this.manipulationName = manipulationName;
    }

    public LocalDate getManipulationDate() {
        return manipulationDate;
    }

    public void setManipulationDate(LocalDate manipulationDate) {
        this.manipulationDate = manipulationDate;
    }
}
