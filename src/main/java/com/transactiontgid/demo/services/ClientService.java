package com.transactiontgid.demo.services;

import com.transactiontgid.demo.exceptions.ClientNotFoundException;
import com.transactiontgid.demo.models.entities.Client;
import com.transactiontgid.demo.models.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ClientService {
  private final ClientRepository repository;

  @Autowired
  public ClientService(ClientRepository clientRepository) {
    this.repository = clientRepository;
  }

  public Client getById(long id) {
    Optional<Client> source = this.repository.findById(id);
    return source.orElseThrow(ClientNotFoundException::new);
  }

}
