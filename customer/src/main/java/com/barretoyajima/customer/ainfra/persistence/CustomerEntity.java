package com.barretoyajima.customer.ainfra.persistence;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Builder
@Table(name="customer_db")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String cpf;
    private String email;
    private String address;
    private Integer addressNumber;


    public CustomerEntity() {
    }

    public CustomerEntity(UUID id, String name, String cpf, String email, String address, Integer addressNumber) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.address = address;
        this.addressNumber = addressNumber;
    }

}