package com.barretoeyajima.ecommerce.product.repository;

import com.barretoeyajima.ecommerce.product.model.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    @Transactional
    @Modifying
    @Query("UPDATE Product u SET u.available = :available WHERE u.id = :id")
    void changeProductAvailabilityOnStock(@Param("id") UUID id, @Param("available") boolean available);

    @Transactional
    @Modifying
    @Query("UPDATE Product p SET p.stockLevel = p.stockLevel + :increment WHERE p.id = :id")
    Integer increaseQuantityById(@Param("id") UUID id, @Param("increment") Integer increment);

    @Transactional
    @Modifying
    @Query("UPDATE Product p SET p.stockLevel = p.stockLevel - :decrement WHERE p.id = :id")
    Integer decreaseQuantityById(@Param("id") UUID id, @Param("decrement") Integer decrement);

}
