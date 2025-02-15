package com.barretoyajima.worker.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.UUID;

@FeignClient(name = "order-api")
public interface OrderChangeStatusClient {

    @PutMapping("/orders/{id}/change-status-to-paid")
    boolean changeToPaidOnOrderApi(@PathVariable("id") UUID id);

}
