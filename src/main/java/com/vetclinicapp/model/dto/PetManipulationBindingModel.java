package com.vetclinicapp.model.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

public class PetManipulationBindingModel {


    @NotNull(message = "Please choose pet!")
    private String petName;

    @NotNull(message = "Please choose manipulation!")
    private String manipulationName;

    @PastOrPresent(message = "Execution date could not be in the future!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate executionDate;


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

    public LocalDate getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(LocalDate executionDate) {
        this.executionDate = executionDate;
    }
}
