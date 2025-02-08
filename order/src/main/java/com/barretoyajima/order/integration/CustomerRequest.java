package com.barretoyajima.order.integration;

import java.util.UUID;

public class CustomerRequest {
    private UUID id;
    private String name;
    private String cpf;
    private String email;
    private String address;
    private Integer addressNumber;

    public CustomerRequest() {
    }

    public CustomerRequest(UUID id, String name, String cpf, String email, String address, Integer addressNumber) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.address = address;
        this.addressNumber = addressNumber;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(Integer addressNumber) {
        this.addressNumber = addressNumber;
    }
}
