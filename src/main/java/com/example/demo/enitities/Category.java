package com.example.demo.enitities;

import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @OneToMany(mappedBy = "category")
  private Set<Product> products = new HashSet<>();

  public Category(String name) {
    this.name = name;
  }

  public Category(Long id) {
    this.id = id;
  }
}
