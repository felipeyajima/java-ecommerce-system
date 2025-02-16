package com.barretoyajima.customer.aapplication.usecases.customer;

import com.barretoyajima.customer.aapplication.gateway.RepositoryOfCustomer;
import com.barretoyajima.customer.adomain.entity.Customer;

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
