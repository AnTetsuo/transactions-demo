package com.transactiontgid.demo.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateClientDTO(
    @NotBlank(message = "is required")
    @Size(min = 2, message = "must be at least 2 characters long")
    String name,
    @Size(min = 11, max = 11, message = "must be 11 characters long")
    @NotBlank
    String naturalRegistry,
    @Email @NotBlank
    String email) {

}
