package com.barretoyajima.order_receiver.event;

import java.util.UUID;

public class ProductDetails {

    private UUID productIdentificator;
    private Integer quantities;


    public ProductDetails(UUID productIdentificator, Integer quantities) {
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

    public Integer getQuantities() {
        return quantities;
    }

    public void setQuantities(Integer quantities) {
        this.quantities = quantities;
    }
}
