package com.example.esd_project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

public record domainRequest(
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
