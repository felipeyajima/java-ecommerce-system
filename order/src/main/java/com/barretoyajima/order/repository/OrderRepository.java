package com.barretoyajima.order.repository;

import com.barretoyajima.order.entity.Order;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {
    @Transactional
    @Modifying
    @Query("UPDATE Order u SET u.status = 'PAID' WHERE u.id = :id")
    void paid(@Param("id") UUID id);

    @Transactional
    @Modifying
    @Query("UPDATE Order u SET u.status = 'DELIVERED' WHERE u.id = :id")
    void delivered(@Param("id") UUID id);

    @Query("select prod.productId from Order p join p.productList prod where p.id = :pedidoId")
    List<String> findAllProductNamesByPedidoId(@Param("pedidoId") UUID pedidoId);

    @Query("select prod.quantity from Order p join p.productList prod where p.id = :pedidoId")
    List<String> findAllProductQuantitysByPedidoId(@Param("pedidoId") UUID pedidoId);

}
