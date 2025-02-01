package com.barretoyajima.order.gateway;

import com.barretoyajima.order.event.NewOrderReceivedEvent;
import com.barretoyajima.order.event.OrderEvent;
import com.barretoyajima.order.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
@AllArgsConstructor
public class OrderProcessor {

    @Autowired
    private OrderService orderService;

    @Bean
    public Function<NewOrderReceivedEvent, OrderEvent> orderProcess(){
        return newOrderReceivedEvent -> {
            OrderEvent orderEvent = orderService.orderProcess(newOrderReceivedEvent);

            //log.info("publicando order status: {} ****", orderEvent.orderStatusList().size());

            return (orderEvent.orderStatusList().isEmpty()) ? null: orderEvent;
        };
    }
}
