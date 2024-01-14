package com.transactiontgid.demo.services;

import com.transactiontgid.demo.exceptions.CompanyNotFoundException;
import com.transactiontgid.demo.models.entities.Company;
import com.transactiontgid.demo.models.repositories.CompanyRepository;
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
}
