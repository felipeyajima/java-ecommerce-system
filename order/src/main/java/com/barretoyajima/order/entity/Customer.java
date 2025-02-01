package com.barretoyajima.order.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "CUSTOMERORDER")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID customerId;
    private String name;
    private String documentNumber;



}
