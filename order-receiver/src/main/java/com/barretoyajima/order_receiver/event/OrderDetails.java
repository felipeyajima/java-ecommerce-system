package com.barretoyajima.order_receiver.event;


import com.barretoyajima.order_receiver.entity.Product;
import lombok.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetails {

    private UUID clientId;
    private List<Product> products = new ArrayList<>();

}
