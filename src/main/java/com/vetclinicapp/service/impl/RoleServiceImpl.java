package com.vetclinicapp.service.impl;


import com.vetclinicapp.model.entity.Role;
import com.vetclinicapp.model.enums.UserRoleEnum;
import com.vetclinicapp.repository.RoleRepository;
import com.vetclinicapp.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {


    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void intiRoles() {

        List<Role> roles =new ArrayList<>();

        if(this.roleRepository.count() == 0){

            Arrays.stream(UserRoleEnum.values())
                    .forEach(userRoleEnum -> {

                        Role role = new Role();
                        role.setRoleName(userRoleEnum);

                        roles.add(role);

                    });


            this.roleRepository.saveAll(roles);


        }





    }
}
