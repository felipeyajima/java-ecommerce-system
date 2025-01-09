package com.barretoeyajima_ecommerce.import_products;

import org.springframework.batch.item.ItemProcessor;

import java.util.UUID;

public class ProductProcessor implements ItemProcessor<Product, Product> {

    @Override
    public Product process(Product item) throws Exception{
        item.setId(UUID.randomUUID());
        return item;
    }
}
