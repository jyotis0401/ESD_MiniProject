package com.example.esd_project.dto;
/*
when getting data the repo will send data in entity form we need in dto so we will need mapper to convert it.

 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

public record domainResponse(
        @NotNull(message="Program is required")
        @JsonProperty("program")
        String program,

        @NotNull(message="Batch is required")
        @JsonProperty("batch")
        int batch,

        @NotNull(message="capacity is required")
        @JsonProperty("capacity")
        int capacity,

        @NotNull(message="Qualification is required")
        @JsonProperty("qualification")
        String qualification
) {
}
