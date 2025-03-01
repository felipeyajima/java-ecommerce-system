package com.barretoyajima.worker.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "order-api")
public interface OrderClient {

    @PutMapping("/orders/{id}/change-status-to-paid")
    boolean changeToPaidOnOrderApi(@PathVariable("id") UUID id);

    @GetMapping("/orders/{id}/produtos")
    List<String> getProductsId(@PathVariable("id") UUID id);

    @GetMapping("/orders/{id}/produtosQtd")
    List<String> getProductsQtd(@PathVariable("id") UUID id);

    @PutMapping("/orders/{id}/change-status-to-delivered")
    boolean changeToDeliveredOnOrderApi(@PathVariable("id") UUID id);

}
