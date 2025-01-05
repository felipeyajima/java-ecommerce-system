package com.barretoeyajima.ecommerce.product.controller;

import com.barretoeyajima.ecommerce.product.model.Product;
import com.barretoeyajima.ecommerce.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<Page<Product>> obterTodos(Pageable pageable){
        Page<Product> products = this.productService.obterTodos(pageable);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{codigo}")
    public Product obterPorId(@PathVariable UUID uuid){
        return this.productService.obterPorCodigo(uuid);
    }

    @PostMapping
    public Product criar(@RequestBody Product product){
        return this.productService.criar(product);
    }

    @PutMapping
    public void atualizar(@RequestBody Product product){
        this.productService.atualizar(product);
    }

    @DeleteMapping("/{codigo}")
    public void deleteProduto(@PathVariable UUID uuid){
         this.productService.deletarPorId(uuid);
    }

    @PutMapping("/{uuid}/makeunavailableonstock")
    public void makeProductUnavailableOnStock(@PathVariable UUID uuid){
        this.productService.makeStockUnavailable(uuid);
    }

    @PutMapping("/{uuid}/makeavailableonstock")
    public void makeProductAvailableOnStock(@PathVariable UUID uuid){
        this.productService.makeStockAvailable(uuid);
    }

    @PutMapping("/{uuid}/increaseQuantityOnStockIn/{quantidade}")
    public void increaseProductAvailableOnStock(@PathVariable("uuid") UUID uuid, @PathVariable("quantidade") Integer quantidade){
        this.productService.increaseQuantityOnStockById(uuid, quantidade);
    }

    @PutMapping("/{uuid}/decreaseQuantityOnStockIn/{quantidade}")
    public void decreaseProductAvailableOnStock(@PathVariable("uuid") UUID uuid, @PathVariable("quantidade") Integer quantidade){
        this.productService.decreaseQuantityOnStockById(uuid, quantidade);
    }


}
