package com.barretoyajima.order.entity;

import com.barretoyajima.order.dto.ProductDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ORDER_PROCESSED")
@Builder
@AllArgsConstructor
public class Order {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> productList = new ArrayList<>();

    private LocalDateTime orderDateRequested;

    private Double totalWeight;

    private Double totalAmount;

    private LocalDateTime deliveryEstimation;
    @OneToOne(cascade = CascadeType.ALL)
    private Payment payment;
    @OneToOne(cascade = CascadeType.ALL)
    private Address deliveryAddress;

    private Double deliveryPrice;

    private String status;

    /*
    public enum Status {
        CREATED,
        PAID,
        DELIVERED,
        FINISHED
    }

     */

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public LocalDateTime getOrderDateRequested() {
        return orderDateRequested;
    }

    public void setOrderDateRequested(LocalDateTime orderDateRequested) {
        this.orderDateRequested = orderDateRequested;
    }

    public Double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDateTime getDeliveryEstimation() {
        return deliveryEstimation;
    }

    public void setDeliveryEstimation(LocalDateTime deliveryEstimation) {
        this.deliveryEstimation = deliveryEstimation;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Double getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(Double deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
