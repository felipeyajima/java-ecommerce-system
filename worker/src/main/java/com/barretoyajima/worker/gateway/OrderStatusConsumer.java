package com.barretoyajima.worker.gateway;

import com.barretoyajima.worker.event.OrderStatus;
import com.barretoyajima.worker.event.OrderStatusMessage;
import com.barretoyajima.worker.integration.PaymentSituationClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class OrderStatusConsumer {


    private final PaymentSituationClient paymentSituationClient;
    private final StreamBridge streamBridge;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${spring.cloud.stream.bindings.validPayment-out-0.destination}")
    private String validPaymentExchange;

    public OrderStatusConsumer(PaymentSituationClient paymentSituationClient, StreamBridge streamBridge) {
        this.paymentSituationClient = paymentSituationClient;
        this.streamBridge = streamBridge;
    }

    @Bean
    public Consumer<OrderStatusMessage> processPayment(PaymentSituationClient paymentClient, StreamBridge streamBridge) {
        return message -> {

            /*
            // adiviced by chatgpt
            message.getOrderStatusList().forEach(order -> {
                Boolean isValid = paymentClient.getSituation(order.getPaymentid());

                if (Boolean.TRUE.equals(isValid)) {
                    System.out.println("Pagamento validado para o pedido: " + order.getOrderId());
                    // Envia o objeto 'order' para a fila ValidatedOrderQueue
                    streamBridge.send("validatedOrder-out-0", order);

                } else {
                    System.out.println("Pagamento inválido para o pedido: " + order.getOrderId());
                    // Lança exceção para que a mensagem seja reprocessada
                    throw new RuntimeException("Pagamento inválido, reprocessando mensagem.");
                }

            });

             */


            for (OrderStatus orderStatus : message.getOrderStatusList()) {
                try {
                    Boolean isValid = paymentClient.getSituation(orderStatus.getPaymentid());

                    if (!isValid) {
                        //log.warn("Payment validation failed for paymentId: {}", orderStatus.getPaymentid());
                        // Rejeita a mensagem para que seja reprocessada
                        throw new AmqpRejectAndDontRequeueException("Payment validation failed");
                    }

                    // Se o pagamento for válido, envia para a nova fila
                    //log.info("Payment validated successfully, sending to valid payment queue. PaymentId: {}",
                    //        orderStatus.getPaymentid());
                    Message message1 = MessageBuilder
                            .withBody(new ObjectMapper().writeValueAsBytes(orderStatus))
                            .setContentType(MessageProperties.CONTENT_TYPE_JSON)
                            .build();

                    //log.info("Payment validated successfully, sending to valid payment queue. PaymentId: {}",
                    //        orderStatus.getPaymentid());
                    rabbitTemplate.send(validPaymentExchange, "", message1);

                } catch (Exception e) {
                    //log.error("Error processing payment for paymentId: {}", orderStatus.getPaymentid(), e);
                    // Em caso de erro na chamada da API, rejeita a mensagem para reprocessamento
                    throw new AmqpRejectAndDontRequeueException("Error processing payment", e);
                }
            }




        };
    }

}
