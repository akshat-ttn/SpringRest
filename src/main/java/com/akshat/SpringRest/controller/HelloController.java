package com.akshat.SpringRest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/welcome")
    public String  getPersonName(){
        return "Welcome to Spring Boot";

    }

}
