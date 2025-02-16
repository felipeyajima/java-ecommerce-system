package com.barretoyajima.worker.gateway;

import com.barretoyajima.worker.event.OrderStatus;
import com.barretoyajima.worker.event.OrderStatusMessage;
import com.barretoyajima.worker.integration.*;
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

import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

@Component
public class OrderStatusConsumer {


    private final PaymentClient paymentClient;
    private final OrderClient orderClient;
    private final DeliveryClient deliveryClient;
    private final ProductClient productClient;

    private final StreamBridge streamBridge;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${spring.cloud.stream.bindings.validPayment-out-0.destination}")
    private String validPaymentExchange;

    public OrderStatusConsumer(PaymentClient paymentClient, OrderClient orderClient, DeliveryClient deliveryClient, ProductClient productClient, StreamBridge streamBridge) {
        this.paymentClient = paymentClient;
        this.orderClient = orderClient;
        this.deliveryClient = deliveryClient;
        this.productClient = productClient;
        this.streamBridge = streamBridge;
    }

    @Bean
    public Consumer<OrderStatusMessage> processPayment(PaymentClient paymentClient, StreamBridge streamBridge) {
        return message -> {

            for (OrderStatus orderStatus : message.getOrderStatusList()) {
                try {
                    Boolean isValid = paymentClient.getSituation(orderStatus.getPaymentid());

                    if (!isValid) {
                        //log.warn("Payment validation failed for paymentId: {}", orderStatus.getPaymentid());
                        System.out.println("Rejeitando a mensagem para que seja reprocessada pois o pedido nao esta pago. PagtoID: " + orderStatus.getPaymentid() );
                        throw new AmqpRejectAndDontRequeueException("Payment validation failed");
                    }

                    System.out.println("mudando status do pedido para pago");
                    orderClient.changeToPaidOnOrderApi(orderStatus.getOrderId());

                    System.out.println("mudando status da entrega para apto a entregar");
                    deliveryClient.changeToReadyOnDeliveryApi(orderStatus.getDeliveryid());


                    System.out.println("Obtendo os produtos do pedido para reduzir no stock");
                    List<String> products = orderClient.getProductsId(orderStatus.getOrderId());
                    List<String> productQtd = orderClient.getProductsQtd(orderStatus.getOrderId());


                    for (int i = 0; i < products.size(); i++){
                        System.out.println("decreasing in " + products.get(i)+ " Stock product id : " + products.get(i));
                        productClient.decreaseInStock(UUID.fromString(products.get(i)), productQtd.get(i));
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


/*
    @Bean
    public Consumer<OrderStatusMessage> processDelivery(DeliveryClient deliveryClient, StreamBridge streamBridge) {

        return message -> {

            for (OrderStatus orderStatus : message.getOrderStatusList()) {
                try {
                    Boolean isValid = deliveryClient.getDeliverySituation(orderStatus.getDeliveryid());

                    if (!isValid) {
                        //log.warn("Payment validation failed for paymentId: {}", orderStatus.getPaymentid());
                        System.out.println("Rejeitando a mensagem para que seja reprocessada pois o pedido ainda nao foi entregue. PedidoID: " + orderStatus.getOrderId() );
                        throw new AmqpRejectAndDontRequeueException("Delivery validation failed");
                    }


                    System.out.println("changing order status to DELIVERED");
                    orderClient.changeToDeliveredOnOrderApi(orderStatus.getOrderId());

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
                    throw new AmqpRejectAndDontRequeueException("Error processing delivery", e);
                }
            }

        };

    }


 */





}
