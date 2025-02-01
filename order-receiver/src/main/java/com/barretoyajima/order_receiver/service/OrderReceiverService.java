package com.barretoyajima.order_receiver.service;

import com.barretoyajima.order_receiver.dto.OrderReceiverRequest;
import com.barretoyajima.order_receiver.entity.OrderReceiver;
import com.barretoyajima.order_receiver.entity.Product;
import com.barretoyajima.order_receiver.repository.OrderReceiverRepository;
import com.barretoyajima.order_receiver.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
@AllArgsConstructor
@Slf4j
@Service
public class OrderReceiverService {

    @Autowired
    private OrderReceiverRepository orderReceiverRepository;

    @Autowired
    private ProductRepository productRepository;



    public OrderReceiver saveOrderReceived(OrderReceiver orderReceiver) {

        orderReceiver.setProcessed(false);
        OrderReceiver orderReceiverSaved = orderReceiverRepository.save(orderReceiver);

        return orderReceiverSaved;

    }

    public List<OrderReceiver> getAllOrder() {
        return orderReceiverRepository.findAll();
    }
}