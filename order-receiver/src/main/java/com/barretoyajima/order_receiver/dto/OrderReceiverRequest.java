package com.barretoyajima.order_receiver.dto;

//import com.barretoyajima.order_receiver.entity.Product;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Getter
@Setter
@Builder
public class OrderReceiverRequest {

    @NonNull
    private Long id;
    @NonNull
    private UUID clientId;
  /*
    @NonNull
    private List<Product> products = new ArrayList<>();


   */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }
/*
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

 */
}
