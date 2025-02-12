package com.barretoyajima.billing.repository;

import com.barretoyajima.billing.entity.Bill;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface BillRepository extends JpaRepository<Bill, UUID> {

    Bill findByDemand(UUID id);

    @Transactional
    @Modifying
    @Query("UPDATE Bill u SET u.status = 'PAID' WHERE u.id = :id")
    void paid(@Param("id") UUID id);

    @Query("SELECT CASE WHEN status = 'PAID' THEN true ELSE false END FROM Bill WHERE id = :id")
    boolean isPaid(@Param("id") UUID id);

}
