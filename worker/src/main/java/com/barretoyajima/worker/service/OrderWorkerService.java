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


    public void determineArrangement(List<OrderStatus> orderStatuses) {
        orderStatuses.forEach(order -> {
            if(order.getStatus().equals("CREATED")) {
                Order savingOrder = new Order();
                savingOrder.setDeliveryid(order.getDeliveryid());
                savingOrder.setPaymentid(order.getPaymentid());
                savingOrder.setStatus(order.getStatus());
                savingOrder.setOrderId(order.getOrderId());
                orderRepository.save(savingOrder);


                System.out.println("order id: " + order.getOrderId());
                System.out.println("delivery id: " + order.getDeliveryid());
                System.out.println("payment id: " + order.getPaymentid());
            } else {

                System.out.println("test");


            }
        });
    }


    public Page<Order> buscarTodos(Pageable pageable){
        return this.orderRepository.findAll(pageable);
    }

}
