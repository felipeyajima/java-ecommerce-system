package com.barretoyajima.customer.aapplication.usecases.customer;

import com.barretoyajima.customer.aapplication.gateway.RepositoryOfCustomer;
import com.barretoyajima.customer.adomain.entity.Customer;

import java.util.UUID;

public class FindCustomer {

    public final RepositoryOfCustomer repository;


    public FindCustomer(RepositoryOfCustomer repository) {
        this.repository = repository;
    }

    public Customer findCustomer(UUID id){
        return this.repository.findCustomer(id);
    }
}
