package com.barretoyajima.order_receiver.controller;

import com.barretoyajima.order_receiver.dto.OrderReceiverRequest;
import com.barretoyajima.order_receiver.entity.OrderReceiver;
import com.barretoyajima.order_receiver.service.OrderReceiverService;
import io.micrometer.common.util.StringUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@AllArgsConstructor
@RequestMapping("/order-receiver")
public class OrderReceiverController {

    @Autowired
    private OrderReceiverService orderReceiverService;

    @PostMapping(path = "/receiving")
    public ResponseEntity<OrderReceiver> orderReceiverRequest(@RequestBody OrderReceiver orderReceiver) {
        //if (StringUtils.isEmpty(orderReceiver.getClientId().toString())){
        //    return ResponseEntity.badRequest().build();
        //}

        OrderReceiver orderReferenceId = orderReceiverService.saveOrderReceived(orderReceiver);
        return ResponseEntity.ok(orderReferenceId);
    }

    @GetMapping
    public List<OrderReceiver> getOrder(){
        return orderReceiverService.getAllOrder();
    }

}