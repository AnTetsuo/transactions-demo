package com.transactiontgid.demo.exceptions;

public class ClientNotFoundException extends RuntimeException{
  public ClientNotFoundException() {
    super("Client Not Found");
  }
}
