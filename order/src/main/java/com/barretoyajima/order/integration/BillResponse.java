package com.barretoyajima.order.integration;

import java.time.LocalDateTime;
import java.util.UUID;

public class BillResponse {

    private UUID id;
    private UUID demand;
    private Double cost;
    private LocalDateTime dateTime;
    private String status;

    public BillResponse(UUID id, UUID demand, Double cost, LocalDateTime dateTime, String status) {
        this.id = id;
        this.demand = demand;
        this.cost = cost;
        this.dateTime = dateTime;
        this.status = status;
    }

    public BillResponse() {
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

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
