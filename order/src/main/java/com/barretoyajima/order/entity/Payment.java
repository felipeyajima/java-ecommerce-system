package com.barretoyajima.order.entity;


import jakarta.persistence.*;
import lombok.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="paymentorder")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String creditCardNumber;
    private Integer CVV;
    private String validUntil;


}
