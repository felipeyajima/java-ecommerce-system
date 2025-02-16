package com.barretoyajima.customer.domain.entity;

import com.barretoyajima.customer.infra.controller.exception.ControllerSystemException;

import java.util.UUID;

public class Customer {

    private UUID id;
    private String name;
    private String cpf;
    private String email;
    private String address;
    private Integer addressNumber;


    public Customer(UUID id, String name, String cpf, String email, String address, Integer addressNumber) {
        this.id = id;
        this.name = name;


        if(cpf == null || !cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")){
            throw new ControllerSystemException("invalid cpf!");
        }
        this.cpf = cpf;

        if(email == null || !email.contains("@")){
            throw new ControllerSystemException("invalid email");
        }
        this.email = email;

        this.address = address;
        this.addressNumber = addressNumber;
    }

    public Customer() {
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
