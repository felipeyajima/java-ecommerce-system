package com.barretoyajima.billing.repository;

import com.barretoyajima.billing.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface BillRepository extends JpaRepository<Bill, UUID> {

    Bill findByDemand(UUID id);

}
