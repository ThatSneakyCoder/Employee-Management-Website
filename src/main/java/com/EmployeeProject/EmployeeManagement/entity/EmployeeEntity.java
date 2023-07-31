package com.EmployeeProject.EmployeeManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class EmployeeEntity {
  @Id
  private Long id;

  private String name;

  private String email;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "owner_id")
  private OwnerEntity owner;

  public EmployeeEntity() {

  }

  public EmployeeEntity(String name, String email, Long id) {
        this.name = name;
        this.email = email;
        this.id = id;
    }

  public OwnerEntity getOwner() {
    return owner;
  }

  public void setOwner(OwnerEntity owner) {
    this.owner = owner;
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}