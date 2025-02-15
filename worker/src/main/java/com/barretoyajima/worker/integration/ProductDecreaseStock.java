package com.barretoyajima.worker.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "products-api")
public interface ProductDecreaseStock {

    @PutMapping("/products/{id}/decreaseQuantityOnStockIn/{qtd}")
    void decreaseInStock(@PathVariable("id") UUID id, @PathVariable("qtd") String qtd);
}
