package com.barretoyajima.order_receiver.service;

import com.barretoyajima.order_receiver.entity.OrderReceiver;
import com.barretoyajima.order_receiver.entity.Product;
import com.barretoyajima.order_receiver.event.NewOrderEvent;
import com.barretoyajima.order_receiver.event.OrderDetails;
import com.barretoyajima.order_receiver.event.ProductDetails;
import com.barretoyajima.order_receiver.repository.OrderReceiverRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;
import java.util.List;
import java.util.Optional;


@Service
@Slf4j
//@AllArgsConstructor
public class OrderEventPublisherService {

    private final OrderReceiverRepository orderReceiverRepository;

    public OrderEventPublisherService(OrderReceiverRepository orderReceiverRepository) {
        this.orderReceiverRepository = orderReceiverRepository;
    }


    public Optional<NewOrderEvent> publishEvent() {

        List<OrderReceiver> orderReceiverList = orderReceiverRepository.findByProcessed(false);

        List<OrderDetails> orderDetails = orderReceiverList.stream().map(order -> {
            OrderDetails orderDetail1 = OrderDetails.builder().build();
            //OrderDetails orderDetail1 = new OrderDetails();
            System.out.println("clientId: " + order.getClientId());
            BeanUtils.copyProperties(order, orderDetail1);
            orderDetail1.setClientId(order.getClientId());

            List<ProductDetails> productList = new ArrayList<>();
            ProductDetails product = new ProductDetails();
            product.setProductIdentificator(UUID.randomUUID());
            product.setQuantities(2);
            //BeanUtils.copyProperties(order.getProducts(), orderDetail1.getProducts());
            //List<Product> products = new ArrayList<>();
            productList.add(product);

            orderDetail1.setProducts(productList);

            System.out.println("cli: "  + orderDetail1.getClientId());
            //System.out.println("prod: " + orderDetail1.getProducts().size());
            System.out.println("prodc: " + orderDetail1.getProducts().size());

            //System.out.println("novo objeto:" + orderDetail1.getClientId());
            order.setProcessed(true);
            return orderDetail1;
        }).toList();

        log.info("###### Checked for new Order request, available recordes for process: {} ", orderReceiverList.size());
        Optional<NewOrderEvent> eventToPublish = Optional.empty();

        if(!orderDetails.isEmpty()){
            log.info("****** send to queue to process");
            NewOrderEvent newOrderEvent = new NewOrderEvent(orderDetails);
            orderReceiverRepository.saveAll(orderReceiverList);
            eventToPublish = Optional.of(newOrderEvent);
        }

        return eventToPublish;
    }


}