package com.barretoyajima.order.event;

import com.barretoyajima.order.entity.Product;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {
    private UUID clientId;
    private List<Product> products = new ArrayList<>();


}
