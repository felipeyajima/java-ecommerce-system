package com.barretoyajima.customer.aapplication.usecases.customer;

import com.barretoyajima.customer.aapplication.gateway.RepositoryOfCustomer;
import com.barretoyajima.customer.adomain.entity.Customer;

public class CreateCustomer {

    private final RepositoryOfCustomer repository;


    public CreateCustomer(RepositoryOfCustomer repository) {
        this.repository = repository;
    }

    public Customer createCustomer(Customer customer){
        return repository.createCustomer(customer);
    }

}
