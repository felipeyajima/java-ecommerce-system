package com.barretoyajima.worker.controller;

import com.barretoyajima.worker.entity.Order;
import com.barretoyajima.worker.service.OrderWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/worker")
public class OrderController {

    @Autowired
    private OrderWorkerService orderWorkerService;

    @GetMapping
    public ResponseEntity<Page<Order>> findAll(Pageable pageable){
        Page<Order> orders = this.orderWorkerService.buscarTodos(pageable);
        return ResponseEntity.ok(orders);
    }


}
