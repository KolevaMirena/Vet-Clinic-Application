package com.vetclinicapp.config;


import com.vetclinicapp.repository.UserRepository;
import com.vetclinicapp.service.impl.VetClinicAppUserDetailsService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {


        httpSecurity.authorizeHttpRequests(

                authorizeRequest ->{

                    authorizeRequest.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                            .requestMatchers("/", "/login", "/register", "/login-error").permitAll()
                            .anyRequest().authenticated();

                }


        ).formLogin(

                formLogin ->{

                formLogin
                        .loginPage("/login")
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/home")
                        .failureForwardUrl("/login-error");

                }

        ).logout(

                logout -> {

                    logout.logoutUrl("/logout")
                            .logoutSuccessUrl("/")
                            .invalidateHttpSession(true);
                }
        );

        //TODO rememberme

      return   httpSecurity.build();

    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository){
        return new VetClinicAppUserDetailsService(userRepository);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }


}
