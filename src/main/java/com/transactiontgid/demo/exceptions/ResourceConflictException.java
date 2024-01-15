package com.transactiontgid.demo.exceptions;

public class ResourceConflictException extends RuntimeException{
  public ResourceConflictException(String message) {
    super(message);
  }
}
