package com.barretoeyajima.ecommerce.product.service.impl;

import com.barretoeyajima.ecommerce.product.controller.exception.ControllerNotFoundException;
import com.barretoeyajima.ecommerce.product.model.Product;
import com.barretoeyajima.ecommerce.product.repository.ProductRepository;
import com.barretoeyajima.ecommerce.product.service.ProductService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Page<Product> obterTodos(Pageable pageable) {
        return this.productRepository
                .findAll(pageable);
    }

    @Override
    public Product criar(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public Product obterPorCodigo(UUID uuid) {
        return this.productRepository
                .findById(uuid)
                .orElseThrow(() -> new ControllerNotFoundException("Produto não existe"));
    }


    @Override
    public void atualizar(Product updatedProduct) {
        this.productRepository.save(updatedProduct);
    }

    @Override
    public void deletarPorId(UUID uuid) {
        this.productRepository.deleteById(uuid);
    }

    @Override
    public Product findBySku(String sku) {
        return null;
    }

    @Override
    public void makeStockUnavailable(UUID uuid) {
        this.productRepository.changeProductAvailabilityOnStock(uuid, false);
    }

    @Override
    public void makeStockAvailable(UUID uuid) {
        this.productRepository.changeProductAvailabilityOnStock(uuid, true);
    }

    @Override
    public Integer increaseQuantityOnStockById(UUID uuid, Integer quantity) {
        return this.productRepository.increaseQuantityById(uuid, quantity);
    }

    @Override
    public void increaseQuantityOnStockBySku(String sku, Integer quantity) {

    }

    @Override
    public Integer decreaseQuantityOnStockById(UUID uuid, Integer quantity) {
        return  this.productRepository.decreaseQuantityById(uuid, quantity);
    }

    @Override
    public void decreaseQuantityOnStockBySku(String sku, Integer quantity) {

    }



}
