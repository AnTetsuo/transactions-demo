package com.transactiontgid.demo.controllers;

import com.transactiontgid.demo.dtos.CreateTransactionDTO;
import com.transactiontgid.demo.dtos.TransactionDTO;
import com.transactiontgid.demo.models.entities.Client;
import com.transactiontgid.demo.models.entities.Company;
import com.transactiontgid.demo.models.entities.Transaction;
import com.transactiontgid.demo.models.entities.TransactionType;
import com.transactiontgid.demo.services.ClientService;
import com.transactiontgid.demo.services.CompanyService;
import com.transactiontgid.demo.services.TransactionService;
import com.transactiontgid.demo.services.TransactionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

  private final CompanyService companyServ;
  private final ClientService clientServ;

  private final TransactionTypeService typeServ;
  private final TransactionService transactionServ;

  @Autowired
  public TransactionController(CompanyService companyServ, ClientService clientServ,
      TransactionService transactionServ, TransactionTypeService transactionTypeService) {
    this.companyServ = companyServ;
    this.clientServ = clientServ;
    this.transactionServ = transactionServ;
    this.typeServ = transactionTypeService;
  }

  @PostMapping()
  public ResponseEntity<TransactionDTO> createTransaction(@RequestBody CreateTransactionDTO payload) {
    Company company = this.companyServ.getById(payload.company());
    Client client = this.clientServ.getById(payload.client());
    TransactionType type = this.typeServ.getById(payload.type());
    Float amount = payload.amount();
    Transaction created = this.transactionServ.create(company, client, type, amount);
    return ResponseEntity.ok(
        new TransactionDTO(created.getCompanyId().getName(), created.getClientId().getName(),
            created.getTypeId().getName(), created.getAmount()));
  }
}
