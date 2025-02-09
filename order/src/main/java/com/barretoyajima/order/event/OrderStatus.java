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
    private UUID paymentid;
    private UUID deliveryid;

    public enum Status {
        CREATED,
        PAID,
        DELIVERED,
        FINISHED
    }

    public OrderStatus(UUID orderId, Status status, UUID paymentid, UUID deliveryid) {
        this.orderId = orderId;
        this.status = status;
        this.paymentid = paymentid;
        this.deliveryid = deliveryid;
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

    public UUID getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(UUID paymentid) {
        this.paymentid = paymentid;
    }

    public UUID getDeliveryid() {
        return deliveryid;
    }

    public void setDeliveryid(UUID deliveryid) {
        this.deliveryid = deliveryid;
    }
}
