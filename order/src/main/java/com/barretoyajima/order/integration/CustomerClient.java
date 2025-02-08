package com.barretoyajima.order.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(value = "customer-api")
public interface CustomerClient {
    @GetMapping(value = "/customers/{id}")
    CustomerRequest retrieveCustomer(@PathVariable UUID id);
}
