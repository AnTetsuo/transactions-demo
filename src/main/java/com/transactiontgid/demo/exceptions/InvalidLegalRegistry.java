package com.transactiontgid.demo.exceptions;

public class InvalidLegalRegistry extends RuntimeException{
  public InvalidLegalRegistry() {
    super("Invalid Legal Registry number!");
  }
}
