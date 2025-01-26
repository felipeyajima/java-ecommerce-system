package com.barretoyajima.order_receiver.service;

import com.barretoyajima.order_receiver.entity.OrderReceiver;
import com.barretoyajima.order_receiver.event.NewOrderEvent;
import com.barretoyajima.order_receiver.event.OrderDetails;
import com.barretoyajima.order_receiver.repository.OrderReceiverRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class OrderEventPublisherService {

    @Autowired
    private OrderReceiverRepository orderReceiverRepository;
    public Optional<NewOrderEvent> publishEvent() {

        List<OrderReceiver> orderReceiverList = orderReceiverRepository.findByProcessed(false);

        List<OrderDetails> orderDetails = orderReceiverList.stream().map(order -> {
            //OrderDetails orderDetail = OrderDetails.builder().build();
            OrderDetails orderDetail1 = new OrderDetails();
            BeanUtils.copyProperties(order, orderDetail1);
            order.setProcessed(true);
            return orderDetail1;
        }).toList();

        //log.info("###### Checked for new Order request, available recordes for process: {} ", orderReceiverList.size());
        Optional<NewOrderEvent> eventToPublish = Optional.empty();

        if(!orderDetails.isEmpty()){
            //log.info("****** send to queue to process");
            NewOrderEvent newOrderEvent = new NewOrderEvent(orderDetails);
            orderReceiverRepository.saveAll(orderReceiverList);
            eventToPublish = Optional.of(newOrderEvent);
        }

        return eventToPublish;
    }


}
