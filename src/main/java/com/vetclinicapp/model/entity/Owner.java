package com.vetclinicapp.model.entity;


import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "owners")
public class Owner extends BaseEntity {





    @Column(nullable = false, unique = true)
    @Length(min = 3, max = 20)
    private String name;

    @Column(unique = true, nullable = false)
    private String phone;


    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    private Set<Pet> pets;

    public Owner() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}
