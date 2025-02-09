package com.barretoyajima.transport.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID demand;
    private String customer;
    private String address;
    @Column(name = "addressnumber")
    private Integer addressNumber;
    @Column(name = "deliveryprice")
    private Double deliveryPrice;
    @Column(name = "productsweight")
    private Double productsWeight;
    private String status;
    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Product> productList = new ArrayList<>();




    public Delivery(UUID id, UUID demand, String customer, String address, Integer addressNumber, Double deliveryPrice, Double productsWeight, String status, List<Product> productList) {
        this.id = id;
        this.demand = demand;
        this.customer = customer;
        this.address = address;
        this.addressNumber = addressNumber;
        this.deliveryPrice = deliveryPrice;
        this.productsWeight = productsWeight;
        this.status = status;
        this.productList = productList;
    }

    public Delivery() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getDemand() {
        return demand;
    }

    public void setDemand(UUID demand) {
        this.demand = demand;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
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

    public Double getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(Double deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public Double getProductsWeight() {
        return productsWeight;
    }

    public void setProductsWeight(Double productsWeight) {
        this.productsWeight = productsWeight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
