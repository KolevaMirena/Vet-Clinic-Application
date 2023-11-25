package com.vetclinicapp.init;


import com.vetclinicapp.service.RoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserRolesInit implements CommandLineRunner {

    private final RoleService roleService;

    public UserRolesInit(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public void run(String... args) throws Exception {

        this
                .roleService.intiRoles();

    }
}
