package com.barretoyajima.worker.event;


import java.util.UUID;

public class OrderStatus {

    private UUID orderId;
    private String status;
    private UUID paymentid;
    private UUID deliveryid;



    public OrderStatus(UUID orderId, String status, UUID paymentid, UUID deliveryid) {
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