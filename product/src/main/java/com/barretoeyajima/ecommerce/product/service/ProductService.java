package com.barretoeyajima.ecommerce.product.service;

import com.barretoeyajima.ecommerce.product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ProductService {

    Page<Product> obterTodos(Pageable pageable);

    public Product criar(Product product);

    public Product obterPorCodigo(UUID uuid);

    public void atualizar(Product product);

    public void deletarPorId(UUID uuid);

    public Product findBySku(String sku);

    public void makeStockUnavailable(UUID uuid);

    public void makeStockAvailable(UUID uuid);
    public Integer increaseQuantityOnStockById(UUID uuid, Integer quantity);
    public void increaseQuantityOnStockBySku(String sku, Integer quantity);
    public Integer decreaseQuantityOnStockById(UUID uuid, Integer quantity);
    public void decreaseQuantityOnStockBySku(String sku, Integer quantity);



}
