package com.barretoyajima.order.event;

import java.util.List;

public record OrderEvent(List<OrderStatus> orderStatusList) {
}
