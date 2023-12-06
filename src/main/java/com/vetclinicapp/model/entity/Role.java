package com.vetclinicapp.model.entity;

import com.vetclinicapp.model.enums.UserRoleEnum;
import jakarta.persistence.*;


import java.util.List;
import java.util.Set;


@Entity
@Table(name = "roles")
public class Role extends BaseEntity{

    @Enumerated(EnumType.STRING)
    UserRoleEnum roleName;


    @ManyToMany(mappedBy = "roles")
    private Set<User> users;


    public Role() {
    }


    public UserRoleEnum getRoleName() {
        return roleName;
    }

    public void setRoleName(UserRoleEnum roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
