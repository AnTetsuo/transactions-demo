package com.transactiontgid.demo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LegalRegistryDTO(
    @Size(min = 14, max = 14, message = "must be 14 characters long")
    @NotBlank
    String legalRegistry) {

}
