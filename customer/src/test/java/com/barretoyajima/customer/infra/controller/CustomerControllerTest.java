package com.barretoyajima.customer.infra.controller;

import com.barretoyajima.customer.application.usecases.customer.CreateCustomer;
import com.barretoyajima.customer.application.usecases.customer.DeleteCustomer;
import com.barretoyajima.customer.application.usecases.customer.FindCustomer;
import com.barretoyajima.customer.application.usecases.customer.ListCustomer;
import com.barretoyajima.customer.domain.entity.Customer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.UUID;
import static org.assertj.core.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class CustomerControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CreateCustomer createCustomer;
    @Mock
    private ListCustomer listCustomers;
    @Mock
    private FindCustomer findCustomer;
    @Mock
    private DeleteCustomer deleteCustomer;


    AutoCloseable mock;

    @BeforeEach
    void setup(){
        mock = MockitoAnnotations.openMocks(this);
        CustomerController customerController = new CustomerController(createCustomer, listCustomers, findCustomer, deleteCustomer);
        mockMvc = MockMvcBuilders.standaloneSetup(customerController)
                .build();
    }

    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }


    @Test
    void shouldAllowCreateCustomer() throws Exception {

        //arrange
        var customer = generateCustomer();
        when(createCustomer.createCustomer(any(Customer.class))).thenAnswer(c -> c.getArgument(0));

        mockMvc.perform(post("/customers")
                        .contentType("application/json")
                        .content(asJsonString(customer)))
                .andExpect(status().isOk());

        verify(createCustomer, times(1)).createCustomer(any(Customer.class));
    }




    public static String asJsonString(final Object object) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(object);
    }


    private Customer generateCustomer(){
        Customer customer1 = new Customer(UUID.randomUUID(), "John", "333.333.333-00", "teste@teste.com.br", "Rua 1", 2);
        return customer1;
    }


}