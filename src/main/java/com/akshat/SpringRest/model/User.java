package com.akshat.SpringRest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = {"password"})
public class User {
    @NotNull(message = "id can't be null")
    private Integer id;

    @NotNull
    @Size(min = 3, message = "Name should have at least 2 characters")
    private String name;

    @Min(value = 8)
    private String password;
}
