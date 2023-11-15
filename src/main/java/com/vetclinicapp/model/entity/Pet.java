package com.vetclinicapp.model.entity;


import com.vetclinicapp.model.enums.PetTypeEnum;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "pets")
public class Pet extends BaseEntity{


    @Column(unique = true, nullable = false)
    @Length(min =3, max = 20)
    private String name;

    @Column(nullable = false)
    @Min(value = 0)
    private Long age;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PetTypeEnum petType;

    @ManyToOne
    private Owner owner;

    @ManyToOne
    private Vet vet;

    @PastOrPresent
    private LocalDate lastManipulationDate;


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



    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
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

    public LocalDate getLastManipulationDate() {
        return lastManipulationDate;
    }

    public void setLastManipulationDate(LocalDate lastManipulationDate) {
        this.lastManipulationDate = lastManipulationDate;
    }


}
