package com.transactiontgid.demo.services;

import com.transactiontgid.demo.dtos.CreateClientDTO;
import com.transactiontgid.demo.exceptions.ClientNotFoundException;
import com.transactiontgid.demo.exceptions.InvalidNaturalRegistry;
import com.transactiontgid.demo.exceptions.ResourceConflictException;
import com.transactiontgid.demo.models.entities.Client;
import com.transactiontgid.demo.models.repositories.ClientRepository;
import com.transactiontgid.demo.utils.validations;
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
  public Client getByNaturalRegistry(String cpf) {
    if (!validations.validateNaturalRegistry(cpf)) {
      throw new InvalidNaturalRegistry();
    }

    Optional<Client> source = this.repository.findByNaturalPersonRegistry(cpf);

    return source.orElseThrow(ClientNotFoundException::new);
  }

  public Client createClient(CreateClientDTO payload) {
    if (!validations.validateNaturalRegistry(payload.naturalRegistry())) {
      throw new InvalidNaturalRegistry();
    }

    if (this.repository
        .findByNaturalPersonRegistry(payload.naturalRegistry())
        .isPresent()) {
      throw new ResourceConflictException("Client already registered!");
    }

    Client entry = new Client(null, payload.name(), payload.naturalRegistry(), payload.email(),
        null);
    return this.repository.save(entry);
  }

}
