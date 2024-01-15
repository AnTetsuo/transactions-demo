package com.transactiontgid.demo.services;

import com.transactiontgid.demo.exceptions.InsufficientFundsException;
import com.transactiontgid.demo.models.entities.Client;
import com.transactiontgid.demo.models.entities.Company;
import com.transactiontgid.demo.models.entities.Transaction;
import com.transactiontgid.demo.models.entities.TransactionType;
import com.transactiontgid.demo.models.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

  private final TransactionRepository repository;

  @Autowired
  public TransactionService(TransactionRepository transactionRepository) {
    this.repository = transactionRepository;
  }

  public Transaction create(Company company, Client client, TransactionType type, Float amount) {
    String op = type.getName();
    Float balance = company.getBalance();
    Float fee = company.getFee();
    if (op.equals("withdraw") && amount * (1 + fee) > balance) {
      throw new InsufficientFundsException();
    }

    if (op.equals("withdraw")) {
      float updateAmount = amount * (1 + fee);
      company.setBalance(balance - updateAmount);
    } else {
      float updateAmount = amount * (1 - fee);
      company.setBalance(balance + updateAmount);
    }

    Transaction transaction = new Transaction(null, company, client, type, amount);
    return this.repository.save(transaction);
  }
}
