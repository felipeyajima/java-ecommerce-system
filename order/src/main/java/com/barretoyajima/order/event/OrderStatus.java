package com.barretoyajima.order.event;

import com.barretoyajima.order.entity.Product;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Builder
public class OrderStatus {
    //private UUID clientId;
    //private List<Product> products = new ArrayList<>();
    private UUID orderId;
    private Status status;

    public enum Status {
        CREATED,
        PAID,
        DELIVERED,
        FINISHED
    }

    public OrderStatus(UUID orderId, Status status) {
        this.orderId = orderId;
        this.status = status;
    }

    public OrderStatus() {
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
