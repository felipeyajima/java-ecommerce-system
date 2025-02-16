package com.barretoyajima.customer.infra.gateway;

import com.barretoyajima.customer.domain.entity.Customer;
import com.barretoyajima.customer.infra.persistence.CustomerEntity;

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