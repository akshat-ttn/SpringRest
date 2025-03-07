package com.akshat.SpringRest.controller;

import com.akshat.SpringRest.model.User;
import com.akshat.SpringRest.repository.UserRepository;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dynamic/users")
public class DynamicUserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/create")
    public ResponseEntity<MappingJacksonValue> createUser(@RequestBody User user) {
        User savedUser = userRepository.createUser(user);

        // Define dynamic filter
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name");
        SimpleFilterProvider filters = new SimpleFilterProvider().addFilter("UserFilter", filter);

        // Apply filter to response
        MappingJacksonValue mapping = new MappingJacksonValue(savedUser);
        mapping.setFilters(filters);

        return mapping;
    }
}
