package com.vetclinicapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(new GeneralPurposeInterceptor()).order(1);
       registry.addInterceptor(new SinglePurposeInterceptor()).addPathPatterns("/pet/**").order(2);
    }
}

