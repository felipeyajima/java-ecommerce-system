package com.barretoyajima.order.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Builder
@Entity
@Table(name="paymentorder")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private UUID bill;

    public Payment(Long id, UUID bill) {
        this.id = id;
        this.bill = bill;
    }

    public Payment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getBill() {
        return bill;
    }

    public void setBill(UUID bill) {
        this.bill = bill;
    }
}
