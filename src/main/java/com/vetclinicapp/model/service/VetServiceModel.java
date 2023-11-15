package com.vetclinicapp.model.service;

import com.vetclinicapp.model.enums.VetSpecialtyEnum;

public class VetServiceModel {


    private Long id;
    private String firstName;

    private String lastName;

    private VetSpecialtyEnum specialtyEnum;

    public VetServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public VetSpecialtyEnum getSpecialtyEnum() {
        return specialtyEnum;
    }

    public void setSpecialtyEnum(VetSpecialtyEnum specialtyEnum) {
        this.specialtyEnum = specialtyEnum;
    }
}
