package com.barretoyajima.transport.repository;

import com.barretoyajima.transport.entity.Delivery;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, UUID> {
    @Transactional
    @Modifying
    @Query("UPDATE Delivery u SET u.status = 'DELIVERED' WHERE u.id = :id")
    void delivered(@Param("id") UUID id);

    @Transactional
    @Modifying
    @Query("UPDATE Delivery u SET u.status = 'READY_TO_DELIVERY' WHERE u.id = :id")
    void todelivery(@Param("id") UUID id);
}
