package com.barretoyajima.customer.aconfig;

import com.barretoyajima.customer.aapplication.gateway.RepositoryOfCustomer;
import com.barretoyajima.customer.aapplication.usecases.customer.CreateCustomer;
import com.barretoyajima.customer.aapplication.usecases.customer.DeleteCustomer;
import com.barretoyajima.customer.aapplication.usecases.customer.FindCustomer;
import com.barretoyajima.customer.aapplication.usecases.customer.ListCustomer;
import com.barretoyajima.customer.ainfra.gateway.CustomerEntityMapper;
import com.barretoyajima.customer.ainfra.gateway.CustomerJpaRepository;
import com.barretoyajima.customer.ainfra.persistence.CustomerRepository;
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
