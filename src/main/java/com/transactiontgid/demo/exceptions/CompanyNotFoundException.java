package com.transactiontgid.demo.exceptions;

public class CompanyNotFoundException extends RuntimeException{
  public CompanyNotFoundException() {
    super("Company Not found");
  }
}
