package com.barretoyajima.worker.service;

import com.barretoyajima.worker.entity.Order;
import com.barretoyajima.worker.event.OrderStatus;
import com.barretoyajima.worker.repository.OrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderWorkerService {

    private final OrderRepository orderRepository;

    public OrderWorkerService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    public Page<Order> buscarTodos(Pageable pageable){
        return this.orderRepository.findAll(pageable);
    }

}
