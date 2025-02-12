package com.barretoyajima.worker.gateway;

import com.barretoyajima.worker.event.OrderEvent;
import com.barretoyajima.worker.service.OrderWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

//@Configuration
public class OrderEventListener {
/*
    @Autowired
    private OrderWorkerService orderWorkerService;

    public OrderEventListener(OrderWorkerService orderWorkerService) {
        this.orderWorkerService = orderWorkerService;
    }

    @Bean
    public Consumer<OrderEvent> orderArrangements(){
        return orderEvent -> {
            System.out.println("received {} event" + orderEvent.orderStatusList().size());
            orderWorkerService.determineArrangement(orderEvent.orderStatusList());
        };
    }

 */

}
