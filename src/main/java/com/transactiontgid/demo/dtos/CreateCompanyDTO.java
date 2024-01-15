package com.transactiontgid.demo.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateCompanyDTO(
    @NotBlank(message = "name is required")
    @Size(min = 2, message = "must be at least 2 characters long")
    String name,
    @Size(min = 14, max = 14, message = "must be 14 characters long")
    @NotBlank
    String legalPersonRegistry,
    @Email
    @NotBlank
    String email,
    @Min(value = 0, message = "fee must be at least 0")
    @NotNull
    Float fee,
    @Min(value = 0)
    @NotNull
    Float balance) {}
