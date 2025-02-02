package com.barretoyajima.order_receiver.service;

import com.barretoyajima.order_receiver.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

   @Autowired
   public ProductRepository productRepository;
}
