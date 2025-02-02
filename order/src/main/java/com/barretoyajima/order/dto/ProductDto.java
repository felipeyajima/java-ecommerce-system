package com.barretoyajima.order.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Data
@Getter
@Setter
public class ProductDto {

    private Long id;

    private String name;
    private UUID productId;
    private Double price;
    private int quantity;
    private String sku;
    private String brand;

}
