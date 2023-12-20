package com.vetclinicapp.service.impl;


import com.vetclinicapp.model.entity.Role;
import com.vetclinicapp.model.entity.User;
import com.vetclinicapp.model.enums.UserRoleEnum;
import com.vetclinicapp.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserDetailsServiceTest {


    private VetClinicAppUserDetailsService userDetailsService;


    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setup(){

        userDetailsService = new VetClinicAppUserDetailsService(
                userRepository
        );

    }


    @Test
    void testUserNotFound(){

    Assertions.assertThrows(UsernameNotFoundException.class,
            ()->{

        userDetailsService.loadUserByUsername("testUser");

        });

    }


    @Test
    void userFoundTest(){

        //Arrange

        User testUser = createTestUser();
        when(userRepository.findByUsername(testUser.getUsername()))
                .thenReturn(Optional.of(testUser));

        //Act

        UserDetails userDetails = userDetailsService.loadUserByUsername(testUser.getUsername());

        //Assert

        Assertions.assertNotNull(userDetails);
        Assertions.assertEquals(testUser.getUsername(), userDetails.getUsername());

    }

    private static User createTestUser(){
       User user = new User();
              user.setUsername("TestUser");
              user.setPassword("jjjjjjj");
              user.setRoles(Set.of(
              ));

              return user;
    }

}
