package com.transactiontgid.demo.dtos;

public record CreateCompanyDTO(
    String name,
    String legalPersonRegistry,
    String email,
    Float fee,
    Float balance) {}
