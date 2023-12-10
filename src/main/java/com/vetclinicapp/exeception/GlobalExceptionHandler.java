package com.vetclinicapp.exeception;
import jakarta.persistence.PersistenceException;
import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex) {


        ModelAndView modelAndView = new ModelAndView("error-page");
        //Map<String, Object> body = new HashMap<>();
        //body.put("message", "An error occurred");

        return  modelAndView; //ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}


