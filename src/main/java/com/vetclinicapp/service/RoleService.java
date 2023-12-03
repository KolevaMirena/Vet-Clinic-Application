package com.vetclinicapp.service;

import com.vetclinicapp.model.entity.Role;

import java.util.List;

public interface RoleService {
    void intiRoles();

    List<Role> getAllRoles();
}
