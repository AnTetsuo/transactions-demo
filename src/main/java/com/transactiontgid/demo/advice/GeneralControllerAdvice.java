package com.transactiontgid.demo.advice;

import com.transactiontgid.demo.exceptions.ClientNotFoundException;
import com.transactiontgid.demo.exceptions.CompanyNotFoundException;
import com.transactiontgid.demo.exceptions.InsufficientFundsException;
import com.transactiontgid.demo.exceptions.InvalidLegalRegistry;
import com.transactiontgid.demo.exceptions.InvalidNaturalRegistry;
import com.transactiontgid.demo.exceptions.InvalidTypeException;
import com.transactiontgid.demo.exceptions.ResourceConflictException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

  @ExceptionHandler({ResourceConflictException.class})
  public ResponseEntity<String> collisionExc(ResourceConflictException ex) {
    return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, String>> methodArgsEx(MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getAllErrors().forEach((error) -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      errors.put(fieldName, errorMessage);
    });
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
  }
  @ExceptionHandler({Exception.class})
  public ResponseEntity<String> broadException() {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body("Internal Server Error");
  }
}
