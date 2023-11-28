package com.vetclinicapp.model.entity;

import com.vetclinicapp.model.enums.UserRoleEnum;
import jakarta.persistence.*;


import java.util.List;


@Entity
@Table(name = "roles")
public class Role extends BaseEntity{

    @Enumerated(EnumType.STRING)
    UserRoleEnum roleName;


    @ManyToMany(mappedBy = "roles")
    private List<User> users;


    public Role() {
    }


    public UserRoleEnum getRoleName() {
        return roleName;
    }

    public void setRoleName(UserRoleEnum roleName) {
        this.roleName = roleName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
