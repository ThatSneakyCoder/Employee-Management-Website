package com.EmployeeProject.EmployeeManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EmployeeEntity {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private String id;

  private String name;

  private String email;

  public EmployeeEntity() {

  }

  public EmployeeEntity(String name, String email, String id) {
        this.name = name;
        this.email = email;
        this.id = id;
    }

  public String getId() {
    return id;
  }

  public void setId(String id) {
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