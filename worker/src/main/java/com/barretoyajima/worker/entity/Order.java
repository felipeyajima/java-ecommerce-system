package com.barretoyajima.worker.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "demand")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "demandid")
    private UUID orderId;
    private String status;
    private UUID paymentid;
    private UUID deliveryid;


    public Order(UUID id, UUID orderId, String status, UUID paymentid, UUID deliveryid) {
        this.id = id;
        this.orderId = orderId;
        this.status = status;
        this.paymentid = paymentid;
        this.deliveryid = deliveryid;
    }

    public Order() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
