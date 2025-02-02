package com.barretoyajima.order.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;


@FeignClient(value = "products-api")
public interface ProductClient {

    @GetMapping(value = "/products/{id}")
    ProductRequest retrieveProduct(@PathVariable UUID id);


}
