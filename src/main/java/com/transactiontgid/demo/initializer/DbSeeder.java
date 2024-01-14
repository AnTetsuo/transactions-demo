package com.transactiontgid.demo.initializer;

import com.transactiontgid.demo.models.entities.Client;
import com.transactiontgid.demo.models.entities.Company;
import com.transactiontgid.demo.models.entities.TransactionType;
import com.transactiontgid.demo.models.repositories.ClientRepository;
import com.transactiontgid.demo.models.repositories.CompanyRepository;
import com.transactiontgid.demo.models.repositories.TransactionTypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbSeeder implements CommandLineRunner {

  private final CompanyRepository companyRepository;
  private final ClientRepository clientRepository;
  private final TransactionTypeRepository transactionTypeRepository;

  public DbSeeder(CompanyRepository companyRepository, ClientRepository clientRepository,
      TransactionTypeRepository transactionTypeRepository) {
    this.companyRepository = companyRepository;
    this.clientRepository = clientRepository;
    this.transactionTypeRepository = transactionTypeRepository;
  }

  @Override
  public void run(String... args) {
    seedCompanies();
    seedClients();
    seedTypes();
  }

  private void seedCompanies() {
    Company c1 = new Company(1L, "F.I.R.S.T", "18196534000109", "first@email.com", 0.02f, 1000.0f,
        null);
    System.out.println(c1);
    Company c2 = new Company(2L, "2ND", "63421016000198", "second@email.com", 0.01f, 2000.0f, null);
    Company c3 = new Company(3L, "3ND", "47959523000123", "third@email.com", 0.05f, 3000.0f, null);
    companyRepository.save(c1);
    companyRepository.save(c2);
    companyRepository.save(c3);
  }

  private void seedClients() {
    Client cl1 = new Client(1L, "FClient", "84439953867", "client@email.com", null);
    clientRepository.save(cl1);
  }

  private void seedTypes() {
    TransactionType deposit = new TransactionType(1L, "deposit", null);
    TransactionType withdraw = new TransactionType(2L, "withdraw", null);
    transactionTypeRepository.save(deposit);
    transactionTypeRepository.save(withdraw);
  }
}
