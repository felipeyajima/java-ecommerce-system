package com.barretoyajima.customer.ainfra.controller;

import com.barretoyajima.customer.aapplication.usecases.customer.CreateCustomer;
import com.barretoyajima.customer.aapplication.usecases.customer.DeleteCustomer;
import com.barretoyajima.customer.aapplication.usecases.customer.FindCustomer;
import com.barretoyajima.customer.aapplication.usecases.customer.ListCustomer;
import com.barretoyajima.customer.adomain.entity.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CreateCustomer createCustomer;
    private final ListCustomer listCustomers;
    private final FindCustomer findCustomer;
    private final DeleteCustomer deleteCustomer;

    public CustomerController(CreateCustomer createCustomer, ListCustomer listCustomers, FindCustomer findCustomer, DeleteCustomer deleteCustomer) {
        this.createCustomer = createCustomer;
        this.listCustomers = listCustomers;
        this.findCustomer = findCustomer;
        this.deleteCustomer = deleteCustomer;
    }




    @PostMapping
    public CustomerDto createCustomer(@RequestBody CustomerDto dto){
        Customer saved = createCustomer.createCustomer(new Customer(dto.getId(), dto.getName(), dto.getCpf(), dto.getEmail(), dto.getAddress(), dto.getAddressNumber()));
        return new CustomerDto(saved.getId(), saved.getName(), saved.getCpf(), saved.getEmail(), saved.getAddress(), saved.getAddressNumber());
    }

    @GetMapping
    public List<CustomerDto> listCustomers(){
        return listCustomers.getAllCustomers().stream().map(c -> new CustomerDto(c.getId(), c.getName(), c.getCpf(), c.getEmail(), c.getAddress(), c.getAddressNumber())).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CustomerDto findCustomer(@PathVariable UUID id){
        Customer customer = findCustomer.findCustomer(id);
        return new CustomerDto(customer.getId(), customer.getName(), customer.getCpf(), customer.getEmail(), customer.getAddress(), customer.getAddressNumber());
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable UUID id){
        deleteCustomer.deleteCustomer(id);
    }
}