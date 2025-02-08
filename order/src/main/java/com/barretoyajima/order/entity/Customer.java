package com.barretoyajima.order.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Builder
@Entity
@Table(name = "CUSTOMERORDER")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID customerId;
    private String name;
    private String documentNumber;

    public Customer(Long id, UUID customerId, String name, String documentNumber) {
        this.id = id;
        this.customerId = customerId;
        this.name = name;
        this.documentNumber = documentNumber;
    }

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }
}
