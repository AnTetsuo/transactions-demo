package com.transactiontgid.demo.exceptions;

public class InsufficientFundsException extends RuntimeException{
  public InsufficientFundsException() {
    super("Insufficient Funds!");
  }
}
