package com.barretoyajima.worker.event;

import java.util.List;
import java.util.Objects;

public class OrderStatusMessage {
    private List<OrderStatus> orderStatusList;

    public List<OrderStatus> getOrderStatusList() {
        return orderStatusList;
    }

    public void setOrderStatusList(List<OrderStatus> orderStatusList) {
        this.orderStatusList = orderStatusList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderStatusMessage that = (OrderStatusMessage) o;
        return Objects.equals(orderStatusList, that.orderStatusList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderStatusList);
    }

    @Override
    public String toString() {
        return "OrderStatusMessage{" +
                "orderStatusList=" + orderStatusList +
                '}';
    }
}
