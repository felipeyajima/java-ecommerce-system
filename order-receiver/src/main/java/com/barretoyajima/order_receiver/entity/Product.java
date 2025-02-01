package com.barretoyajima.order_receiver.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@NoArgsConstructor
//@Getter
//@Setter
@Entity
@Table(name = "PRODUCT")
@AllArgsConstructor
public class Product {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long internalId;

    private UUID productIdentificator;
    private int quantities;

    public Long getInternalId() {
        return internalId;
    }

    public void setInternalId(Long internalId) {
        this.internalId = internalId;
    }

    public UUID getProductIdentificator() {
        return productIdentificator;
    }

    public void setProductIdentificator(UUID productIdentificator) {
        this.productIdentificator = productIdentificator;
    }

    public int getQuantities() {
        return quantities;
    }

    public void setQuantities(int quantities) {
        this.quantities = quantities;
    }
}