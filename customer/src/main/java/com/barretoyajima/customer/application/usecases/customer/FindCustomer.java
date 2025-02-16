package com.barretoyajima.customer.application.usecases.customer;

import com.barretoyajima.customer.application.gateway.RepositoryOfCustomer;
import com.barretoyajima.customer.domain.entity.Customer;

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
