package com.akshat.SpringRest.service;

import com.akshat.SpringRest.model.Employee;
import com.akshat.SpringRest.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public ResponseEntity<List<Employee>> getAllEmployees() {
        return  repository.findAll();
    }

    public ResponseEntity<Employee> getEmployeeById(Integer id) {
        return repository.findEmployeeById(id);
    }

    public ResponseEntity<Employee> createEmployee(Employee employee) {
        return repository.saveEmployee(employee);
    }

    public ResponseEntity<String> deleteEmployeeById(Integer id) {
        return repository.deleteEmployeeById(id);
    }

    public ResponseEntity<Employee> updateEmployee(Employee employee, Integer id) {
        return repository.updateEmployee(employee, id);
    }
}
