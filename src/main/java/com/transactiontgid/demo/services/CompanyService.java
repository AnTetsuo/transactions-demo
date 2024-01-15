package com.transactiontgid.demo.services;

import com.transactiontgid.demo.dtos.CreateCompanyDTO;
import com.transactiontgid.demo.exceptions.CompanyNotFoundException;
import com.transactiontgid.demo.exceptions.InvalidLegalRegistry;
import com.transactiontgid.demo.exceptions.ResourceConflictException;
import com.transactiontgid.demo.models.entities.Company;
import com.transactiontgid.demo.models.repositories.CompanyRepository;
import com.transactiontgid.demo.utils.validations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CompanyService {

  private final CompanyRepository repository;

  @Autowired
  public CompanyService(CompanyRepository companyRepository) {
    this.repository = companyRepository;
  }

  public Company getById(long id) {
    Optional<Company> source = this.repository.findById(id);
    return source.orElseThrow(CompanyNotFoundException::new);
  }

  public Company getByLegalPersonRegistry(String cnpj) {
    if (!validations.validateLegalRegistry(cnpj)) {
      throw new InvalidLegalRegistry();
    }

    Optional<Company> source = this.repository.findByLegalPersonRegistry(cnpj);
    return source.orElseThrow(CompanyNotFoundException::new);
  }

  public Company createCompany(CreateCompanyDTO payload) {
    System.out.println(payload);
    if (!validations.validateLegalRegistry(payload.legalPersonRegistry())) {
      throw new InvalidLegalRegistry();
    }
    System.out.println(this.repository
        .findByLegalPersonRegistry(payload.legalPersonRegistry()));
    if (this.repository
        .findByLegalPersonRegistry(payload.legalPersonRegistry())
        .isPresent()) {
      throw new ResourceConflictException("Company already registered!");
    }

    Company entry = new Company(
        null,
        payload.name(),
        payload.legalPersonRegistry(),
        payload.email(),
        payload.fee(),
        payload.fee(),
        null
    );

    return this.repository.save(entry);
  }
}
