package com.barretoyajima.order.event;

import java.util.List;

public record NewOrderReceivedEvent(List<OrderDetail> orderDetailList) {
}
