package com.barretoyajima.order_receiver.event;


import com.barretoyajima.order_receiver.dto.ProductDto;
import com.barretoyajima.order_receiver.entity.Product;
import lombok.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Builder
public class OrderDetails {

    public OrderDetails(UUID clientId, List<ProductDetails> products) {
        this.clientId = clientId;
        this.products = products;
    }

    public OrderDetails() {
    }


    private UUID clientId;
    private List<ProductDetails> products = new ArrayList<>();

    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }

    public List<ProductDetails> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDetails> products) {
        this.products = products;
    }
}
