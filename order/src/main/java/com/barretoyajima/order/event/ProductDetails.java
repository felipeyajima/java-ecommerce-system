package com.barretoyajima.order.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class ProductDetails {

    private UUID productIdentificator;
    private int quantities;

    public ProductDetails(UUID productIdentificator, int quantities) {
        this.productIdentificator = productIdentificator;
        this.quantities = quantities;
    }

    public ProductDetails() {
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
