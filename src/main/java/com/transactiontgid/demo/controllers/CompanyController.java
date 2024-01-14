package com.transactiontgid.demo.controllers;

import com.transactiontgid.demo.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
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

}
