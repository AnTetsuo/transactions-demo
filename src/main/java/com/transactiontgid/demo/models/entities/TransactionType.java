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
@Table(name = "Transaction_Type")
public class TransactionType {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false)
  private String name;

  @OneToMany(mappedBy = "type")
  @JsonIgnore
  private List<Transaction> transactions;
  public TransactionType() {
  }

  public TransactionType(Long id, String name, List<Transaction> transactions) {
    this.id = id;
    this.name = name;
    this.transactions = transactions;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public List<Transaction> getTransactions() {
    return transactions;
  }

  public void setTransactions(
      List<Transaction> transactions) {
    this.transactions = transactions;
  }
}
