package com.barretoyajima.worker.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.UUID;

@FeignClient(name = "delivery-api")
public interface DeliveryChangeToReadyToDelivery {
    @PutMapping("/deliveries/{id}/change-status-to-ready-to-delivery")
    boolean changeToReadyOnDeliveryApi(@PathVariable("id") UUID id);

}
