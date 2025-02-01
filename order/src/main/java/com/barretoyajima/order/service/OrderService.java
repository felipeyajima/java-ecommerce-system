package com.barretoyajima.order.service;

import com.barretoyajima.order.entity.Order;
import com.barretoyajima.order.event.NewOrderReceivedEvent;
import com.barretoyajima.order.event.OrderDetails;
import com.barretoyajima.order.event.OrderEvent;
import com.barretoyajima.order.event.OrderStatus;
import com.barretoyajima.order.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    public OrderEvent orderProcess(NewOrderReceivedEvent newOrderReceivedEvent) {
        List<OrderDetails> orderDetailsList = newOrderReceivedEvent.orderDetailsList();
        List<OrderStatus> orderStatusList = orderDetailsList.stream().map(orderDetails -> {
           //##OrderStatus orderStatus = OrderStatus.builder().build();
            System.out.println("clientId: " + orderDetails.getClientId());
            System.out.println("qtd de produtos" + orderDetails.getProducts().size());
            OrderStatus orderStatus = new OrderStatus();
            //BeanUtils.copyProperties(orderDetail, orderStatus);
            //##log.info("order detail: " + orderDetail.getClientId());

            //orderStatus.setStatus(OrderStatus.Status.CREATED);

            System.out.println(orderDetails);

            return orderStatus;


        }).toList();


        OrderEvent orderEvent = new OrderEvent(orderStatusList);
        //saveOrderStatus(orderStatusList);
        return orderEvent;
    }

    private void saveOrderStatus(List<OrderStatus> orderStatusList) {

        List<Order> orderList = orderStatusList.stream().map(orderStatus -> {
            Order order = new Order();
            //BeanUtils.copyProperties(orderStatus, order);
            //order.setStatus(Order.Status.CREATED);
            return order;
        }).toList();
        //log.info("saving order status");
        orderRepository.saveAll(orderList);
    }
}
