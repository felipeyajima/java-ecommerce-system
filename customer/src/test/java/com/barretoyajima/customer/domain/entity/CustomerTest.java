package com.barretoyajima.customer.domain.entity;

import com.barretoyajima.customer.infra.controller.exception.ControllerSystemException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.UUID;

public class CustomerTest {

    @Test
    public void shouldntSaveEmailWithInvalidFormat(){
        Assertions.assertThrows(ControllerSystemException.class,
                () -> new Customer(UUID.randomUUID(), "John", "000.000.000-00", "john.com", "Rua 1", 2));
        Assertions.assertThrows(ControllerSystemException.class,
                () -> new Customer(UUID.randomUUID(), "John", "000.000.000-00", "", "Rua 2", 2));
    }

    @Test
    public void shouldntSaveCpfWithInvalidFormat(){
        Assertions.assertThrows(ControllerSystemException.class,
                () -> new Customer(UUID.randomUUID(), "John", "00000000000", "john@teste.com","Rua 1", 2));
        Assertions.assertThrows(ControllerSystemException.class,
                () -> new Customer(UUID.randomUUID(), "John", "", "john@teste.com", "Rua 1", 2));
    }


    @Test
    void shouldRegisterCustomer(){
        Customer customer1 = new Customer(UUID.randomUUID(), "John", "333.333.333-00", "teste@teste.com.br", "Rua 1", 2);

        Assertions.assertEquals(Customer.class, customer1.getClass());
        Assertions.assertEquals("John", customer1.getName());
        Assertions.assertEquals("333.333.333-00", customer1.getCpf());
        Assertions.assertEquals("teste@teste.com.br", customer1.getEmail());
        Assertions.assertEquals("Rua 1", customer1.getAddress());
        Assertions.assertEquals(2, customer1.getAddressNumber());
    }



}