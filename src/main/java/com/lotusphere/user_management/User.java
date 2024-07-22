package com.lotusphere.user_management;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.Data;

import java.time.LocalDate;

@Data
public class User {

    private int id;

    @NotBlank(message = "User name cannot be blank")
    private String name;

    @Min(value = 1, message = "Age cannot be less than 1")
    private int age;

    @Email(message = "E-mail format is not correct")
    private String email;

    @Past(message = "Birthday must be a past date")
    private LocalDate birthday;
}


