package com.transactiontgid.demo.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "Companies")
public class Company {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false)
  private String name;
  @Column(nullable = false, unique = true)
  private String legalPersonRegistry;

  @Column(nullable = false)
  private String email;
  private Float fee;

  @Column(nullable = false)
  private Double balance;

  @OneToMany(mappedBy = "company")
  @JsonIgnore
  private List<Transaction> transactions;

  public Company() {
  }

  public Company(Long id, String name, String legalPersonRegistry, String email, Float fee,
      Double balance, List<Transaction> transactions) {
    this.id = id;
    this.name = name;
    this.legalPersonRegistry = legalPersonRegistry;
    this.email = email;
    this.fee = fee;
    this.transactions = transactions;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLegalPersonRegistry() {
    return legalPersonRegistry;
  }

  public void setLegalPersonRegistry(String legalPersonRegistry) {
    this.legalPersonRegistry = legalPersonRegistry;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Float getFee() {
    return fee;
  }

  public void setFee(Float fee) {
    this.fee = fee;
  }

  public Double getBalance() {
    return balance;
  }

  public void setBalance(Double balance) {
    this.balance = balance;
  }

  public List<Transaction> getTransactions() {
    return transactions;
  }

  public void setTransactions(
      List<Transaction> transactions) {
    this.transactions = transactions;
  }
}
