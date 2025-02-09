package com.barretoyajima.worker.event;

import java.util.List;

public record OrderEvent(List<OrderStatus> orderStatusList) {
}
