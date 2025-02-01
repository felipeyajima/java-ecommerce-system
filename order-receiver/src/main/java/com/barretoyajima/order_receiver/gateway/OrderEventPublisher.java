package com.barretoyajima.order_receiver.gateway;

import com.barretoyajima.order_receiver.event.NewOrderEvent;
import com.barretoyajima.order_receiver.service.OrderEventPublisherService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;
import java.util.function.Supplier;

//@Slf4j

@Configuration
public class OrderEventPublisher {


    private final OrderEventPublisherService orderEventPublisherService;

    public OrderEventPublisher(OrderEventPublisherService orderEventPublisherService) {
        this.orderEventPublisherService = orderEventPublisherService;
    }

    @Bean
    public Supplier<NewOrderEvent> publishNewOrderEvent(){
        return () -> {
            Optional<NewOrderEvent> newOrderEvent = orderEventPublisherService.publishEvent();
            return newOrderEvent.orElse(null);
        };
    }


}
