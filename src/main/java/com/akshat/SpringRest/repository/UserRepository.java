package com.akshat.SpringRest.repository;

import com.akshat.SpringRest.exception.EmployeeNotFoundException;
import com.akshat.SpringRest.model.Employee;
import com.akshat.SpringRest.model.User;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Repository
public class UserRepository {

    List<User> userList = new ArrayList<>(Arrays.asList(
            new User(1,"Manvi Jain","manvi123"),
            new User(2,"Akshat Srivastava","akshat123"),
            new User(3,"Kunal Rawat","kunal123")
    ));

    public ResponseEntity<List<User>> getAllUsers() {
        if(userList.isEmpty())
        {
            return new ResponseEntity<>(userList,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(userList,HttpStatus.OK);
    }

    public ResponseEntity<User> createUser(@Valid User user) {
        userList.add(user);
        return new ResponseEntity<>(user,HttpStatus.CREATED);
    }
}













