package com.vetclinicapp.model.view;

import java.time.LocalDate;

public class PetManipulationViewModel {




    private String petName;
    private String manipulationName;
    private LocalDate manipulationDate;


    public PetManipulationViewModel() {
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
