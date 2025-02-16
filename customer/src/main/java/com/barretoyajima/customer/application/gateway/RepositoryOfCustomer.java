package com.barretoyajima.customer.application.gateway;

import com.barretoyajima.customer.domain.entity.Customer;

import java.util.List;
import java.util.UUID;

public interface RepositoryOfCustomer {

    Customer createCustomer(Customer customer);

    List<Customer> listEverything();

    Customer findCustomer(UUID id);

    void deleteCustomer(UUID id);
}
