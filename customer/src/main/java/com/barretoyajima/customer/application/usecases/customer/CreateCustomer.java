package com.barretoyajima.customer.application.usecases.customer;

import com.barretoyajima.customer.application.gateway.RepositoryOfCustomer;
import com.barretoyajima.customer.domain.entity.Customer;

public class CreateCustomer {

    private final RepositoryOfCustomer repository;


    public CreateCustomer(RepositoryOfCustomer repository) {
        this.repository = repository;
    }

    public Customer createCustomer(Customer customer){
        return repository.createCustomer(customer);
    }

}
