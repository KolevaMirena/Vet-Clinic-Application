package com.vetclinicapp.repository;


import com.vetclinicapp.model.dto.UserRegisterBindingModel;
import com.vetclinicapp.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsUserByUsername(String name);

    Optional<User> findByUsername(String username);
}
