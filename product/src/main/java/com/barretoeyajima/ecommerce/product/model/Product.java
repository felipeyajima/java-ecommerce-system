package com.barretoeyajima.ecommerce.product.model;



import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String description;
    private Double price;
    private String category;
    private String imageUrl;
    private String sku;
    private String brand;
    private Double weight;
    private boolean available;
    private int stockLevel;


    public Product() {
    }

    public Product(UUID id, String name, String description, Double price, String category, String imageUrl, String sku, String brand, Double weight, boolean available, int stockLevel) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.imageUrl = imageUrl;
        this.sku = sku;
        this.brand = brand;
        this.weight = weight;
        this.available = available;
        this.stockLevel = stockLevel;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getSku() {
        return sku;
    }

    public String getBrand() {
        return brand;
    }

    public Double getWeight() {
        return weight;
    }

    public boolean isAvailable() {
        return available;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }
}
