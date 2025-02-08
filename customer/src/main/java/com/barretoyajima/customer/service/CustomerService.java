package com.barretoyajima.customer.service;

import com.barretoyajima.customer.controller.exception.ControllerNotFoundException;
import com.barretoyajima.customer.dto.CustomerDto;
import com.barretoyajima.customer.model.Customer;
import com.barretoyajima.customer.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Page<CustomerDto> findAll(Pageable pageable){
        Page<Customer> customers = customerRepository.findAll(pageable);
        return customers.map(this::toDto);
    }

    public CustomerDto findById(UUID uuid){
        Customer customer = customerRepository.findById(uuid).orElseThrow(()-> new ControllerNotFoundException("customer nao encontrado"));
        return toDto(customer);
    }

    public CustomerDto save(CustomerDto customerDto){
        Customer customer = toEntity(customerDto);
        customer = customerRepository.save(customer);
        return toDto(customer);
    }

    public CustomerDto update(UUID id, CustomerDto customerDto){
        try{
            Customer customer = customerRepository.getReferenceById(id);
            customer.setName(customerDto.name());
            customer.setCpf(customerDto.cpf());
            customer.setEmail(customerDto.email());
            customer.setAddress(customerDto.address());
            customer.setAddressNumber(customerDto.addressNumber());

            customer = customerRepository.save(customer);

            return toDto(customer);

        } catch (EntityNotFoundException e){
            throw new ControllerNotFoundException("customer not found");
        }
    }

    public void delete(UUID id){
        customerRepository.deleteById(id);
    }





    private CustomerDto toDto(Customer customer){
        return new CustomerDto(
                customer.getId(),
                customer.getName(),
                customer.getCpf(),
                customer.getEmail(),
                customer.getAddress(),
                customer.getAddressNumber()
        );
    }

    private Customer toEntity(CustomerDto customerDto){
        return new Customer(
                customerDto.id(),
                customerDto.name(),
                customerDto.cpf(),
                customerDto.email(),
                customerDto.address(),
                customerDto.addressNumber()
        );
    }



}
