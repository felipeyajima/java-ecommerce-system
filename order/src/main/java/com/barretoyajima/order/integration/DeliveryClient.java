package com.barretoyajima.order.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "delivery-api")
public interface DeliveryClient {

    @PostMapping(value = "/deliveries")
    DeliveryResponse postDelivery(@RequestBody DeliveryRequest deliveryRequest);
}
