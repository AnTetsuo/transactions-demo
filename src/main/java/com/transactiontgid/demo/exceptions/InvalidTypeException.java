package com.transactiontgid.demo.exceptions;

public class InvalidTypeException extends RuntimeException{
  public InvalidTypeException() {
    super("Invalid transaction type");
  }
}
