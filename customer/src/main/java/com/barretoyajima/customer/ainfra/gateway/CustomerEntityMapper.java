package com.barretoyajima.customer.ainfra.gateway;

import com.barretoyajima.customer.adomain.entity.Customer;
import com.barretoyajima.customer.ainfra.persistence.CustomerEntity;

public class CustomerEntityMapper {

    public CustomerEntity toEntity(Customer customer){
        return new CustomerEntity(
                customer.getId(),
                customer.getName(),
                customer.getCpf(),
                customer.getEmail(),
                customer.getAddress(),
                customer.getAddressNumber()
        );
    }

    public Customer toDomain(CustomerEntity entity){
        return new Customer(
                entity.getId(),
                entity.getName(),
                entity.getCpf(),
                entity.getEmail(),
                entity.getAddress(),
                entity.getAddressNumber()
        );
    }

}