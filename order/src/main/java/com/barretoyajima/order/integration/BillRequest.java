package com.barretoyajima.order.integration;

import java.time.LocalDateTime;
import java.util.UUID;

public class BillRequest {

    private UUID demand;
    private Double cost;

    public BillRequest() {
    }

    public BillRequest(UUID demand, Double cost) {

        this.demand = demand;
        this.cost = cost;

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

}
