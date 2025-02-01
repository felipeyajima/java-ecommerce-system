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
@Table(name="addressorder")
public class Address {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String postalCode;
    private String place;
    private String number;
    private String complement;


}
