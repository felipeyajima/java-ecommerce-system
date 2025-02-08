package com.barretoyajima.customer.controller;

import com.barretoyajima.customer.dto.CustomerDto;
import com.barretoyajima.customer.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<Page<CustomerDto>> findAll(
            @PageableDefault(size = 10, page = 0)Pageable pageable
            ){
        Page<CustomerDto> customerDtos = customerService.findAll(pageable);
        return ResponseEntity.ok(customerDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> findById(@PathVariable UUID id){
        CustomerDto customerDto = customerService.findById(id);
        return ResponseEntity.ok(customerDto);
    }

    @PostMapping
    public ResponseEntity<CustomerDto> save(@RequestBody CustomerDto customerDto){
        CustomerDto savedCustomer = customerService.save(customerDto);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CustomerDto> update(@PathVariable UUID id, @RequestBody CustomerDto customerDto){
        CustomerDto updatedCustomer = customerService.update(id, customerDto);
        return  ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }






}
