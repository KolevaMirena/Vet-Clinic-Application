package com.vetclinicapp.repository;


import com.vetclinicapp.model.entity.Role;
import com.vetclinicapp.model.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findRoleByRoleName(UserRoleEnum name);
}
