package com.transactiontgid.demo.models.repositories;

import com.transactiontgid.demo.models.entities.Client;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
  Optional<Client> findByNaturalPersonRegistry(String naturalPersonRegistry);
}
