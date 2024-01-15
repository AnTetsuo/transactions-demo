package com.transactiontgid.demo.advice;

import com.transactiontgid.demo.exceptions.ClientNotFoundException;
import com.transactiontgid.demo.exceptions.CompanyNotFoundException;
import com.transactiontgid.demo.exceptions.InsufficientFundsException;
import com.transactiontgid.demo.exceptions.InvalidLegalRegistry;
import com.transactiontgid.demo.exceptions.InvalidNaturalRegistry;
import com.transactiontgid.demo.exceptions.InvalidTypeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeneralControllerAdvice {

  @ExceptionHandler({ClientNotFoundException.class})
  public ResponseEntity<String> clientNotFound(ClientNotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
  }

  @ExceptionHandler({CompanyNotFoundException.class})
  public ResponseEntity<String> companyNotFound(CompanyNotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
  }

  @ExceptionHandler({InsufficientFundsException.class})
  public ResponseEntity<String> insufficientFunds(InsufficientFundsException ex) {
    return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(ex.getMessage());
  }

  @ExceptionHandler({InvalidTypeException.class})
  public ResponseEntity<String> invalidType(InvalidTypeException ex) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
  }

  @ExceptionHandler({InvalidLegalRegistry.class})
  public ResponseEntity<String> invalidCnpj(InvalidLegalRegistry ex) {
    return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(ex.getMessage());
  }

  @ExceptionHandler({InvalidNaturalRegistry.class})
  public ResponseEntity<String> invalidCpf(InvalidNaturalRegistry ex) {
    return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(ex.getMessage());
  }

  @ExceptionHandler({Exception.class})
  public ResponseEntity<String> broadException() {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body("Internal Server Error");
  }
}
