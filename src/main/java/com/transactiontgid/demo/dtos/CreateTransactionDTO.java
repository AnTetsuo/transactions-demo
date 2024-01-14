package com.transactiontgid.demo.dtos;

public record CreateTransactionDTO(Long company, Long client, Long type, Float amount) {
}
