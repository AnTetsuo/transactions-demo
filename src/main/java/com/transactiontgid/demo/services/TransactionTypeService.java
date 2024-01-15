package com.transactiontgid.demo.services;

import com.transactiontgid.demo.exceptions.InvalidTypeException;
import com.transactiontgid.demo.models.entities.TransactionType;
import com.transactiontgid.demo.models.repositories.TransactionTypeRepository;
import java.util.ArrayList;
import java.util.Arrays;
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

  public TransactionType getByName(String name) {
    ArrayList<String> options = new ArrayList<>(Arrays.asList("withdraw", "deposit"));
    if (!options.contains(name)) {
      throw new InvalidTypeException();
    }
    Optional<TransactionType> source = this.repository.findByName(name);
    return source.orElseThrow(InvalidTypeException::new);
  }
}
