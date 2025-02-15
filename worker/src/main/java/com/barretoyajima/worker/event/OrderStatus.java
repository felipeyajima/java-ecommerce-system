package com.barretoyajima.worker.event;


import java.util.Objects;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderStatus that = (OrderStatus) o;
        return Objects.equals(orderId, that.orderId) && Objects.equals(status, that.status) && Objects.equals(paymentid, that.paymentid) && Objects.equals(deliveryid, that.deliveryid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, status, paymentid, deliveryid);
    }

    @Override
    public String toString() {
        return "OrderStatus{" +
                "orderId=" + orderId +
                ", status='" + status + '\'' +
                ", paymentid=" + paymentid +
                ", deliveryid=" + deliveryid +
                '}';
    }
}