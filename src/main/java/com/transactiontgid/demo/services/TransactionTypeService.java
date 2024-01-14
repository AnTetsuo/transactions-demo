package com.transactiontgid.demo.services;

import com.transactiontgid.demo.exceptions.InvalidTypeException;
import com.transactiontgid.demo.models.entities.TransactionType;
import com.transactiontgid.demo.models.repositories.TransactionTypeRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class TransactionTypeService {
  private final TransactionTypeRepository repository;

  public TransactionTypeService(TransactionTypeRepository transactionTypeRepository) {
    this.repository = transactionTypeRepository;
  }

  public TransactionType getById(long id) {
    Optional<TransactionType> source = this.repository.findById(id);
    return source.orElseThrow(InvalidTypeException::new);
  }
}
