package com.barretoyajima.order.integration;

import java.util.List;
import java.util.UUID;

public class DeliveryResponse {

    private UUID id;
    private UUID demand;
    private String customer;
    private String address;
    private Integer addressNumber;
    private Double deliveryPrice;
    private Double productsWeight;
    private List<DeliveryProduct> productList;

    public DeliveryResponse(UUID id, UUID demand, String customer, String address, Integer addressNumber, Double deliveryPrice, Double productsWeight, List<DeliveryProduct> productList) {
        this.id = id;
        this.demand = demand;
        this.customer = customer;
        this.address = address;
        this.addressNumber = addressNumber;
        this.deliveryPrice = deliveryPrice;
        this.productsWeight = productsWeight;
        this.productList = productList;
    }

    public DeliveryResponse() {
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

    public List<DeliveryProduct> getProductList() {
        return productList;
    }

    public void setProductList(List<DeliveryProduct> productList) {
        this.productList = productList;
    }
}
