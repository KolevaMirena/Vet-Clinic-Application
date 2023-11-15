package com.vetclinicapp.model.dto;


import com.vetclinicapp.model.enums.VetSpecialtyEnum;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class VetRegisterBindingModel{


    @Size(min = 3, max = 20, message = "Vet first name length must be between 3 and 20 characters!")
    private String firstName;

    @Size(min = 3, max = 20, message = "Vet last name length must be between 3 and 20 characters!")
    private String lastName;

    @NotNull(message = "Vet specialty could not be empty")
    private VetSpecialtyEnum vetSpecialtyEnum;


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

    public VetSpecialtyEnum getVetSpecialtyEnum() {
        return vetSpecialtyEnum;
    }

    public void setVetSpecialtyEnum(VetSpecialtyEnum vetSpecialtyEnum) {
        this.vetSpecialtyEnum = vetSpecialtyEnum;
    }
}
