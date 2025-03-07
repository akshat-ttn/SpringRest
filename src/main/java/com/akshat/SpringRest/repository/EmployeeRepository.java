package com.akshat.SpringRest.repository;

import com.akshat.SpringRest.exception.EmployeeNotFoundException;
import com.akshat.SpringRest.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Repository
public class EmployeeRepository {

    List<Employee> employeeList = new ArrayList<>(Arrays.asList(
            new Employee(1,"Manvi Jain",21),
            new Employee(2,"Akshat Srivastava",22),
            new Employee(3,"Kunal Rawat",22),
            new Employee(4,"Krishna Sharma",23),
            new Employee(5,"Arsh Nadeem",24)
    ));

    public ResponseEntity<List<Employee>> findAll() {
        if(employeeList.isEmpty())
        {
            return new ResponseEntity<>(employeeList,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employeeList,HttpStatus.OK);
    }

    public ResponseEntity<Employee> findEmployeeById(Integer id) {
        for(Employee employees : employeeList)
            if(Objects.equals(employees.getId(), id))
                return new ResponseEntity<>(employees,HttpStatus.OK);
        throw new EmployeeNotFoundException("Employee Not Found with id : "+ id);
    }

    public ResponseEntity<Employee> saveEmployee(Employee employee) {
        employeeList.add(employee);
        return new ResponseEntity<>(employee,HttpStatus.CREATED);
    }

    public ResponseEntity<String> deleteEmployeeById(Integer id) {
        for(int i=0;i<employeeList.size();i++)
            if(employeeList.get(i).getId()==id){
                employeeList.remove(i);
                return new ResponseEntity<>("success",HttpStatus.OK);
            }
        return new ResponseEntity<>("Employee not present.",HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Employee> updateEmployee(Employee employee, Integer id) {
        Employee oldEmp = employeeList.stream().filter(emp -> Objects.equals(emp.getId(), id)).findFirst().orElse(null);

        if (oldEmp == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        oldEmp.setName(employee.getName()!=null && !employee.getName().isEmpty() ? employee.getName() : oldEmp.getName());
        oldEmp.setAge(employee.getAge()!=null ? employee.getAge() : oldEmp.getAge());
        return new ResponseEntity<>(oldEmp,HttpStatus.OK);

    }
}













