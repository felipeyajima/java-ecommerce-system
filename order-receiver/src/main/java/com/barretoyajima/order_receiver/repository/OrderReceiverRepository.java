package com.barretoyajima.order_receiver.repository;

import com.barretoyajima.order_receiver.entity.OrderReceiver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderReceiverRepository extends JpaRepository<OrderReceiver, Long> {

    List<OrderReceiver> findByClientId(UUID id);

    List<OrderReceiver> findByProcessed(boolean b);
}
