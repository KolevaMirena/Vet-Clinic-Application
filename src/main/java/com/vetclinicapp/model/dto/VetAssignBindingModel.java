package com.vetclinicapp.model.dto;


import jakarta.validation.constraints.NotNull;

public class VetAssignBindingModel {


    @NotNull(message = "Pet name field could not be empty!")
    private String petName;

    @NotNull(message = "Vet name field could not be empty!")
    private String vetName;


    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getVetName() {
        return vetName;
    }

    public void setVetName(String vetName) {
        this.vetName = vetName;
    }
}
