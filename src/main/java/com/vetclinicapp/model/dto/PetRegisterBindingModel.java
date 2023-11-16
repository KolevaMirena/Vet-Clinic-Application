package com.vetclinicapp.model.dto;

import com.vetclinicapp.model.entity.Manipulation;
import com.vetclinicapp.model.enums.PetTypeEnum;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.validation.constraints.*;
import java.util.List;

public class PetRegisterBindingModel {


    @NotNull
    @Size(min =3, max = 20, message = "Pet name length should be between 3 and 20 characters!")
    private String name;


    @NotNull(message = "Please enter pet age!")
    @Min(value = 0, message = "Pet age should be positive number!")
    private Long age;


    @NotNull(message = "Pet type field could not be empty")
    private PetTypeEnum petType;


    @NotBlank(message = "Owner phone field could not be blank!")
    @Pattern(regexp="(^$|[0-9]{10})", message = "Phone number should contains only numbers!")
    @Size(min = 10, max = 10, message = "Owner phone length should be exactly 10 digits!")
    private String ownerPhone;


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

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }
}
