package com.transactiontgid.demo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record NaturalRegistryDTO(
    @Size(min = 11, max = 11, message = "must be 11 characters long")
    @NotBlank
    String naturalRegistry) {

}
