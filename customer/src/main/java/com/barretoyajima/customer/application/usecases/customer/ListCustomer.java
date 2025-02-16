package com.barretoyajima.customer.application.usecases.customer;

import com.barretoyajima.customer.application.gateway.RepositoryOfCustomer;
import com.barretoyajima.customer.domain.entity.Customer;

import java.util.List;

public class ListCustomer {

    private final RepositoryOfCustomer repository;


    public ListCustomer(RepositoryOfCustomer repository) {
        this.repository = repository;
    }

    public List<Customer> getAllCustomers(){
        return this.repository.listEverything();
    }
}
