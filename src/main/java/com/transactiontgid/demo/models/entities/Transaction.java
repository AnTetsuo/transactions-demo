package com.transactiontgid.demo.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Transactions")
public class Transaction {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "company", nullable = false)
  private Company company;

  @ManyToOne
  @JoinColumn(name = "client", nullable = false)
  private Client client;

  @ManyToOne
  @JoinColumn(name = "type", nullable = false)
  private TransactionType type;
  @Column(nullable = false)
  private Double amount;

  public Transaction() {
  }

  public Transaction(Long id, Company company, Client client, TransactionType type, Double amount) {
    this.id = id;
    this.company = company;
    this.client = client;
    this.type = type;
    this.amount = amount;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Company getCompanyId() {
    return company;
  }

  public void setCompanyId(Company company) {
    this.company = company;
  }

  public Client getClientId() {
    return client;
  }

  public void setClientId(Client client) {
    this.client = client;
  }

  public TransactionType getTypeId() {
    return type;
  }

  public void setTypeId(TransactionType type) {
    this.type = type;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }
}
