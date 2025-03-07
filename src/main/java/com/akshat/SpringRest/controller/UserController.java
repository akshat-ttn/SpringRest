package com.akshat.SpringRest.controller;

import com.akshat.SpringRest.model.Employee;
import com.akshat.SpringRest.model.User;
import com.akshat.SpringRest.repository.UserRepository;
import com.akshat.SpringRest.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        return userRepository.createUser(user);
    }

}















