package com.barretoyajima.worker.event;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String VALID_PAYMENT_EXCHANGE = "ValidPaymentOrders";
    public static final String VALID_PAYMENT_QUEUE = "ValidPaymentOrders.queue";

    @Bean
    public MessageConverter messageConverter() {
        Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter();
        converter.setCreateMessageIds(true);
        return converter;
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Queue validPaymentQueue() {
        return new Queue(VALID_PAYMENT_QUEUE, true);
    }

    @Bean
    public DirectExchange validPaymentExchange() {
        return new DirectExchange(VALID_PAYMENT_EXCHANGE, true, false);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder
                .bind(validPaymentQueue())
                .to(validPaymentExchange())
                .with(""); // routing key vazio para direct exchange
    }

}
