package com.transactiontgid.demo.controllers;

import com.transactiontgid.demo.dtos.CompanyDTO;
import com.transactiontgid.demo.dtos.CreateCompanyDTO;
import com.transactiontgid.demo.dtos.LegalRegistryDTO;
import com.transactiontgid.demo.models.entities.Company;
import com.transactiontgid.demo.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies")
public class CompanyController {

  private final CompanyService service;

  @Autowired
  public CompanyController(CompanyService companyService) {
    this.service = companyService;
  }

  @GetMapping
  public ResponseEntity<CompanyDTO> getCompanyByCnpj(
      @RequestBody LegalRegistryDTO payload
  ) {
    Company company = this.service
        .getByLegalPersonRegistry(payload.legalRegistry());
    var res = new CompanyDTO(company.getName(), company.getEmail(),
        company.getLegalPersonRegistry());
    return ResponseEntity.ok(res);
  }

  @PostMapping
  public ResponseEntity<CompanyDTO> createCompany(
      @RequestBody CreateCompanyDTO payload
  ) {
    Company entry = this.service.createCompany(payload);
    var res = new CompanyDTO(
        entry.getName(),
        entry.getEmail(),
        entry.getLegalPersonRegistry()
    );
    return ResponseEntity.status(HttpStatus.CREATED).body(res);
  }

}
