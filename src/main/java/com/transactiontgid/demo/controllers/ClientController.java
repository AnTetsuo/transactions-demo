package com.transactiontgid.demo.controllers;

import com.transactiontgid.demo.dtos.ClientDTO;
import com.transactiontgid.demo.dtos.CreateClientDTO;
import com.transactiontgid.demo.dtos.NaturalRegistryDTO;
import com.transactiontgid.demo.models.entities.Client;
import com.transactiontgid.demo.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController {

  private final ClientService service;

  @Autowired
  public ClientController(ClientService clientService) {
    this.service = clientService;
  }

  @GetMapping
  public ResponseEntity<ClientDTO> getClientByNaturalRegistry(
      @RequestBody NaturalRegistryDTO payload) {
    Client user = this.service.getByNaturalRegistry(payload.naturalRegistry());
    ClientDTO client = new ClientDTO(user.getName(), user.getEmail(),
        user.getNaturalPersonRegistry());
    return ResponseEntity.ok(client);
  }

  @PostMapping
  public ResponseEntity<ClientDTO> createClient(
      @RequestBody CreateClientDTO payload
  ) {
    Client entry = this.service.createClient(payload);
    ClientDTO created = new ClientDTO(entry.getName(), entry.getEmail(),
        entry.getNaturalPersonRegistry());
    return ResponseEntity.status(HttpStatus.CREATED).body(created);
  }
}
