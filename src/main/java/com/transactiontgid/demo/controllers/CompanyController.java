package com.transactiontgid.demo.controllers;

import com.transactiontgid.demo.models.entities.Company;
import com.transactiontgid.demo.services.CompanyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
  public ResponseEntity<List<Company>> check() {
    return ResponseEntity.ok(this.service.getHello());
  }
}
