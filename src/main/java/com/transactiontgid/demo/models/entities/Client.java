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
@Table(name = "Clients")
public class Client {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false, unique = true)
  private String naturalPersonRegistry;

  @Column(nullable = false)
  private String email;

  @OneToMany(mappedBy = "client")
  @JsonIgnore
  private List<Transaction> transactions;

  public Client() {
  }

  public Client(Long id, String name, String naturalPersonRegistry, String email,
      List<Transaction> transactions) {
    this.id = id;
    this.name = name;
    this.naturalPersonRegistry = naturalPersonRegistry;
    this.email = email;
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

  public String getNaturalPersonRegistry() {
    return naturalPersonRegistry;
  }

  public void setNaturalPersonRegistry(String naturalPersonRegistry) {
    this.naturalPersonRegistry = naturalPersonRegistry;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public List<Transaction> getTransactions() {
    return transactions;
  }

  public void setTransactions(
      List<Transaction> transactions) {
    this.transactions = transactions;
  }
}
