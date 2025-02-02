package com.barretoyajima.order_receiver.dto;

import java.util.UUID;

public class ProductDto {

    public ProductDto(UUID productIdentificator, int quantities) {
        this.productIdentificator = productIdentificator;
        this.quantities = quantities;
    }

    public ProductDto() {
    }

    private UUID productIdentificator;
    private int quantities;


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
