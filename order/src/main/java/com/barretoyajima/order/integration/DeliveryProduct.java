package com.barretoyajima.order.integration;

import java.util.UUID;

public class DeliveryProduct {
    private UUID productId;
    private String brand;
    private String name;
    private String sku;
    private Integer quantity;

    public DeliveryProduct(UUID productId, String brand, String name, String sku, Integer quantity) {
        this.productId = productId;
        this.brand = brand;
        this.name = name;
        this.sku = sku;
        this.quantity = quantity;
    }

    public DeliveryProduct() {
    }

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
