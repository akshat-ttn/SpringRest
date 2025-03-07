package com.akshat.SpringRest.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @NotNull(message = "id can't be null")
    private Integer id;

    @NotNull
    @Size(min = 3, message = "Name should have at least 2 characters")
    private String name;

    @NotNull
    @Min(value = 18, message = "Age must be at least 18")
    private Integer age;
}
