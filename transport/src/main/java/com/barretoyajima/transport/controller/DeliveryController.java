package com.barretoyajima.transport.controller;

import com.barretoyajima.transport.entity.Delivery;
import com.barretoyajima.transport.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/deliveries")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @GetMapping
    public ResponseEntity<Page<Delivery>> findAll(Pageable pageable){
        Page<Delivery> deliveries = this.deliveryService.buscarTodos(pageable);
        return ResponseEntity.ok(deliveries);
    }

    @GetMapping("/{id}")
    public Delivery obterPorId(@PathVariable UUID id){
        return this.deliveryService.obterPorCodigo(id);
    }

    @PostMapping
    public Delivery save(@RequestBody Delivery delivery){
        delivery.setStatus("CREATED");
        return this.deliveryService.criar(delivery);
    }

    @PutMapping("/{id}/change-status-to-delivered")
    public void changeStatusToDelivered(@PathVariable UUID id){
        this.deliveryService.delivered(id);
    }

    @PutMapping("/{id}/change-status-to-ready-to-delivery")
    public void changeStatusToReadyToDelivery(@PathVariable UUID id){
        this.deliveryService.todelivery(id);
    }

}
