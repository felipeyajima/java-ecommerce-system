package com.barretoyajima.customer.aapplication.usecases.customer;

import com.barretoyajima.customer.aapplication.gateway.RepositoryOfCustomer;

import java.util.UUID;

public class DeleteCustomer {

    public final RepositoryOfCustomer repository;


    public DeleteCustomer(RepositoryOfCustomer repository) {
        this.repository = repository;
    }

    public void deleteCustomer(UUID id){
        this.repository.deleteCustomer(id);
    }
}
