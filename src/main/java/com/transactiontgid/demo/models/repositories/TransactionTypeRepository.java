package com.transactiontgid.demo.models.repositories;

import com.transactiontgid.demo.models.entities.TransactionType;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionTypeRepository extends JpaRepository<TransactionType, Long> {
  public Optional<TransactionType> findByName(String name);
}
