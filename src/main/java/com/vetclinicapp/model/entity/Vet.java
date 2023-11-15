package com.vetclinicapp.model.entity;


import com.vetclinicapp.model.enums.VetSpecialtyEnum;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "vets")
public class Vet extends BaseEntity{


    @Column(nullable = false, unique = true)
    @Length(min = 3, max = 20)
    private String firstName;

    @Column(nullable = false, unique = true)
    @Length(min = 3, max = 20)
    private String lastName;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VetSpecialtyEnum specialtyEnum;



    @OneToMany(mappedBy = "vet", fetch = FetchType.EAGER)
    private List<Pet> pets;

    public Vet() {
    }


    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
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
