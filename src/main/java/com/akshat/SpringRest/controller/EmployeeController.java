package com.akshat.SpringRest.controller;

import com.akshat.SpringRest.model.Employee;
import com.akshat.SpringRest.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return service.getAllEmployees();
    }

//    @Operation(summary = "getUserById", description = "Returns a user as per the id")
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
        return service.getEmployeeById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
        return service.createEmployee(employee);
    }

//        @PostMapping(path = "/create", consumes = MediaType.APPLICATION_XML_VALUE)
//        public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
//            return service.createEmployee(employee);
//        }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable Integer id) {
        return service.updateEmployee(employee, id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Integer id) {
        return service.deleteEmployeeById(id);
    }


}




