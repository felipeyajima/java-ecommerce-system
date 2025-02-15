package com.barretoyajima.order.controller;

import com.barretoyajima.order.entity.Order;
import com.barretoyajima.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<Page<Order>> findAll(Pageable pageable){
        Page<Order> orders = this.orderService.buscarTodos(pageable);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public Order obterPorId(@PathVariable UUID id){
        return this.orderService.obterPorCodigo(id);
    }

    @PutMapping("/{id}/change-status-to-paid")
    public boolean changeStatusToPaid(@PathVariable UUID id){

        return this.orderService.paid(id);

    }
    @PutMapping("/{id}/change-status-to-delivered")
    public boolean changeStatusToDelivered(@PathVariable UUID id){
        return this.orderService.delivered(id);
    }
}
