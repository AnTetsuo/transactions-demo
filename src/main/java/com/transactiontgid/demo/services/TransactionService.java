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
    if (amount * (1 + company.getFee()) > company.getBalance()) {
      throw new InsufficientFundsException();
    }

    if (type.getName().equals("withdraw")) {
      float updateAmount = amount * (1 + company.getFee());
      company.setBalance(company.getBalance() - updateAmount);
    } else {
      float updateAmount = amount * (1 - company.getFee());
      company.setBalance(company.getBalance() + updateAmount);
    }
    
    Transaction op = new Transaction(null, company, client, type, amount);
    Transaction created = this.repository.save(op);
    return created;
  }
}
