package com.barretoyajima.customer.config;

import com.barretoyajima.customer.application.gateway.RepositoryOfCustomer;
import com.barretoyajima.customer.application.usecases.customer.CreateCustomer;
import com.barretoyajima.customer.application.usecases.customer.DeleteCustomer;
import com.barretoyajima.customer.application.usecases.customer.FindCustomer;
import com.barretoyajima.customer.application.usecases.customer.ListCustomer;
import com.barretoyajima.customer.infra.gateway.CustomerEntityMapper;
import com.barretoyajima.customer.infra.gateway.CustomerJpaRepository;
import com.barretoyajima.customer.infra.persistence.CustomerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {

    @Bean
    CreateCustomer createCustomer(RepositoryOfCustomer repositoryOfCustomer){
        return new CreateCustomer(repositoryOfCustomer);
    }

    @Bean
    ListCustomer listCustomer(RepositoryOfCustomer repositoryOfCustomer){
        return new ListCustomer(repositoryOfCustomer);
    }

    @Bean
    FindCustomer findCustomer(RepositoryOfCustomer repositoryOfCustomer){
        return new FindCustomer(repositoryOfCustomer);
    }

    @Bean
    DeleteCustomer deleteCustomer(RepositoryOfCustomer repositoryOfCustomer){
        return new DeleteCustomer(repositoryOfCustomer);
    }

    @Bean
    CustomerJpaRepository customerJpaRepository(CustomerRepository repository, CustomerEntityMapper mapper){
        return new CustomerJpaRepository(repository, mapper);
    }

    @Bean
    CustomerEntityMapper returnMapperCustomer(){
        return new CustomerEntityMapper();
    }

}
