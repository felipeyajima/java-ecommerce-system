package com.barretoyajima.order.event;

import com.barretoyajima.order.entity.Product;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatus {
    private UUID clientId;
    private List<Product> products = new ArrayList<>();
    private Status status;

    public enum Status {
        CREATED,
        PAID,
        DELIVERED,
        FINISHED
    }


    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
