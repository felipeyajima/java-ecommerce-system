package com.barretoyajima.order.event;

import com.barretoyajima.order.entity.Order;

import java.util.List;

public record NewOrderReceivedEvent(List<OrderDetails> orderDetailsList) {
}
