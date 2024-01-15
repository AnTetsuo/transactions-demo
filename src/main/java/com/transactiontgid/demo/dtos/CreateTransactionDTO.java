package com.transactiontgid.demo.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CreateTransactionDTO(
    @Size(min = 14, max = 14, message = "must be 14 characters long")
    @NotBlank
    String cnpj,
    @Size(min = 11, max = 11, message = "must be 11 characters long")
    @NotBlank
    String cpf,
    @NotBlank
    String type,
    @NotNull
    @Min(0)
    Float amount) {
}
