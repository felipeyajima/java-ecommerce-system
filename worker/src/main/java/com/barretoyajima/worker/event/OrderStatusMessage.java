package com.barretoyajima.worker.event;

import java.util.List;

public class OrderStatusMessage {
    private List<OrderStatus> orderStatusList;

    public List<OrderStatus> getOrderStatusList() {
        return orderStatusList;
    }

    public void setOrderStatusList(List<OrderStatus> orderStatusList) {
        this.orderStatusList = orderStatusList;
    }
}
