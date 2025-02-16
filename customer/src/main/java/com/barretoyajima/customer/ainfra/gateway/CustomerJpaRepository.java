package com.barretoyajima.customer.ainfra.gateway;

import com.barretoyajima.customer.aapplication.gateway.RepositoryOfCustomer;
import com.barretoyajima.customer.adomain.entity.Customer;
import com.barretoyajima.customer.ainfra.controller.exception.ControllerSystemException;
import com.barretoyajima.customer.ainfra.persistence.CustomerEntity;
import com.barretoyajima.customer.ainfra.persistence.CustomerRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CustomerJpaRepository implements RepositoryOfCustomer {

    private final CustomerRepository repository;

    private final CustomerEntityMapper mapper;

    public CustomerJpaRepository(CustomerRepository repository, CustomerEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        CustomerEntity entity = mapper.toEntity(customer);
        repository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public List<Customer> listEverything() {
        return repository.findAll().stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Customer findCustomer(UUID id) {
        CustomerEntity customer = repository.findById(id).orElseThrow(()-> new ControllerSystemException("customer not found"));
        return mapper.toDomain(customer);
    }

    @Override
    public void deleteCustomer(UUID id) {
        this.repository.deleteById(id);
    }


}