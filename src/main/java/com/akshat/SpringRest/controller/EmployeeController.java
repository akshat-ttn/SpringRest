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

    @Operation(summary = "Get all employees", description = "Fetches a list of all employees")
    @GetMapping("")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return service.getAllEmployees();
    }

    @Operation(summary = "Get employee by ID", description = "Fetches a single employee by their ID")
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
        return service.getEmployeeById(id);
    }

    @Operation(summary = "Create a new employee", description = "Creates a new employee with the given details")
    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
        return service.createEmployee(employee);
    }

    @Operation(summary = "Update an employee", description = "Updates an existing employee by their ID")
    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable Integer id) {
        return service.updateEmployee(employee, id);
    }

    @Operation(summary = "Delete an employee", description = "Deletes an employee by their ID")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Integer id) {
        return service.deleteEmployeeById(id);
    }


}


//        @PostMapping(path = "/create", consumes = MediaType.APPLICATION_XML_VALUE)
//        public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
//            return service.createEmployee(employee);
//        }

