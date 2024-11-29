package com.example.esd_project.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public record StudentsDTO(
        @NotNull(message = "firstname is required")
        @JsonProperty("first_name")
        String firstname,

        @NotNull(message = "lastname is required")
        @JsonProperty("last_name")
        String lastname,

        @NotNull(message = "email is required")
        @JsonProperty("email")
        String email,

        @NotNull(message = "rollnumber is required")
        @JsonProperty("roll_number")
        int rollnumber,

        @NotNull(message = "cgpa is required")
        @JsonProperty("cgpa")
        double cgpa
) {
}
