package com.vetclinicapp.model.entity;


import com.vetclinicapp.model.enums.ManipulationTypeEnum;
import jakarta.persistence.*;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Entity
@Table(name = "manipulation_types")
public class ManipulationType extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ManipulationTypeEnum name;

    @Column(nullable = false)
    @Length(min = 50, max = 200)
    private String description;

    @OneToMany(mappedBy = "type")
    List<Manipulation> manipulations;

    public ManipulationTypeEnum getName() {
        return name;
    }

    public void setName(ManipulationTypeEnum name) {
        this.name = name;
        setDescription(name);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private void setDescription(ManipulationTypeEnum enumName){
        String description = "";
        switch (enumName){
            case OPTIONAL->  description = "This type includes manipulations that are optional, but recommended for your pet. It can include prophylactic, checking vision and hearing, etc.";
            case MANDATORY-> description = "This manipulation type includes all mandatory vaccinations.";
        }

        this.description = description;
    }
}
