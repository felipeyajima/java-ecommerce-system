package com.barretoyajima.order_receiver.event;

import java.util.List;

public record NewOrderEvent(List<OrderDetails> orderDetailsList) {
}