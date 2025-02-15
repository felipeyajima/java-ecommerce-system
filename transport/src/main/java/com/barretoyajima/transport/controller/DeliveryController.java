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
    public boolean changeStatusToDelivered(@PathVariable UUID id){

        return this.deliveryService.delivered(id);
    }

    @PutMapping("/{id}/change-status-to-ready-to-delivery")
    public boolean changeStatusToReadyToDelivery(@PathVariable UUID id){

        return this.deliveryService.todelivery(id);
    }

}
