package com.barretoyajima.order.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID delivery;

    public Delivery(Long id, UUID delivery) {
        this.id = id;
        this.delivery = delivery;
    }

    public Delivery() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getDelivery() {
        return delivery;
    }

    public void setDelivery(UUID delivery) {
        this.delivery = delivery;
    }
}
