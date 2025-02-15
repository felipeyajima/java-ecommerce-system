package com.barretoyajima.order.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
@Entity
@Table(name="productorder")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private UUID productId;
    private Double price;
    private int quantity;
    private String sku;
    private String brand;

    public Product(Long id, String name, UUID productId, Double price, int quantity, String sku, String brand) {
        this.id = id;
        this.name = name;
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
        this.sku = sku;
        this.brand = brand;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
