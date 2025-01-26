package com.barretoyajima.order.entity;

import com.barretoyajima.order.event.OrderStatus;
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

    private Customer customer;

    private List<Product> productList = new ArrayList<>();

    private LocalDateTime orderDateRequested;

    private Double totalWeight;

    private Double totalAmount;

    private LocalDateTime deliveryEstimation;

    private Payment payment;

    private Address deliveryAddress;

    private Double deliveryPrice;

    private OrderStatus.Status status;

    public enum Status {
        CREATED,
        PAID,
        DELIVERED,
        FINISHED
    }


}
