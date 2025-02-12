package com.barretoyajima.worker.gateway;

import com.barretoyajima.worker.event.OrderStatus;
import com.barretoyajima.worker.event.OrderStatusMessage;
import com.barretoyajima.worker.integration.PaymentSituationClient;
import com.barretoyajima.worker.integration.PaymentSituationResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class OrderStatusConsumer {

    private final RabbitTemplate rabbitTemplate;
    private final PaymentSituationClient paymentSituationClient;
    private final ObjectMapper objectMapper;

    public OrderStatusConsumer(RabbitTemplate rabbitTemplate, PaymentSituationClient paymentSituationClient, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.paymentSituationClient = paymentSituationClient;
        this.objectMapper = objectMapper;
    }

    @Bean
    public Consumer<Message<String>> proccessMessage(){
        return msg -> {
            try {
                OrderStatusMessage orderStatusMessage = objectMapper.readValue(msg.getPayload(), OrderStatusMessage.class);
                boolean allApproved = true;

                for (OrderStatus order : orderStatusMessage.getOrderStatusList()){
                    System.out.println("verificando pedido: " + order.getOrderId());

                    boolean situationResponse = paymentSituationClient.getSituation(order.getPaymentid());

                    if (!situationResponse){
                        System.out.println("pedido" + order.getOrderId() + " nao aprovado. Reenviando para a fila");
                        allApproved = false;
                        break;
                    }
                }

                if (allApproved) {
                    System.out.println("todos os pedidos estão aprovados, encaminhando para a fila fila de delivery");
                    sendToDeliveryQueue(msg.getPayload());
                } else {
                    resendToOriginPaymentQueue(msg);
                }

            } catch (Exception e){
                System.err.println("error on messagem processing " + e.getMessage());
                resendToOriginPaymentQueue(msg);
            }
        };
    }

    private void resendToOriginPaymentQueue(Message<String> msg){
        String paymentQueue = "OrderPaymentProcessing";
        rabbitTemplate.convertAndSend(paymentQueue, msg.getPayload());
    }

    private void sendToDeliveryQueue(String message){
        String deliveryQueue = "delivery";
        rabbitTemplate.convertAndSend(deliveryQueue, message);
    }

}
