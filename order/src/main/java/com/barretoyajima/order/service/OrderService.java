package com.barretoyajima.order.service;

import com.barretoyajima.order.controller.exception.ControllerNotFoundException;
import com.barretoyajima.order.entity.*;
import com.barretoyajima.order.event.NewOrderReceivedEvent;
import com.barretoyajima.order.event.OrderDetails;
import com.barretoyajima.order.event.OrderEvent;
import com.barretoyajima.order.event.OrderStatus;
import com.barretoyajima.order.integration.*;
import com.barretoyajima.order.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class OrderService {

    @Autowired
    private ProductClient productClient;

    @Autowired
    private CustomerClient customerClient;
    @Autowired
    private BillClient billClient;

    @Autowired
    private DeliveryClient deliveryClient;


    @Autowired
    private OrderRepository orderRepository;
    public OrderEvent orderProcess(NewOrderReceivedEvent newOrderReceivedEvent) {
        List<OrderDetails> orderDetailsList = newOrderReceivedEvent.orderDetailsList();

        List<OrderStatus> orderStatusList = orderDetailsList.stream().map(orderDetails -> {

            Address address = new Address();
            Customer customer = new Customer();
            Payment payment = new Payment();
            Product product = new Product();
            Order order = new Order();

            //DELIVERY OBJECTS



            System.out.println("indo ate a api de customer");
            CustomerRequest customerRequest = customerClient.retrieveCustomer(orderDetails.getClientId());

            customer.setCustomerId(customerRequest.getId());
            customer.setName(customerRequest.getName());
            customer.setDocumentNumber(customerRequest.getCpf());

            address.setPlace(customerRequest.getAddress());
            address.setNumber(customerRequest.getAddressNumber().toString());
            address.setPostalCode("00000000");
            address.setComplement("sem complemento");

            Double totalCostOfProducts = 0.0;
            Double totalWeight = 0.0;
            Double deliveryCost = 10.0;



            List<Product> products = new ArrayList<>();

            // lista de produtos na requisição para a api de delivery
            List<DeliveryProduct> deliveryProducts = new ArrayList<>();


            for (int i = 0; i < orderDetails.getProducts().size(); i++) {
                ProductRequest productRequest = productClient.retrieveProduct(orderDetails.getProducts().get(i).getProductIdentificator());

                Product internalProduct = new Product();
                // produtos para requisicao de delivery
                DeliveryProduct deliveryProduct = new DeliveryProduct();

                internalProduct.setQuantity(orderDetails.getProducts().get(i).getQuantities());
                internalProduct.setProductId(productRequest.getId());
                internalProduct.setName(productRequest.getName());
                internalProduct.setSku(productRequest.getSku());
                internalProduct.setBrand(productRequest.getBrand());
                internalProduct.setPrice(productRequest.getPrice());

                // produtos para requisicao de delivery
                deliveryProduct.setBrand(productRequest.getBrand());
                deliveryProduct.setName(productRequest.getName());
                deliveryProduct.setProductId(productRequest.getId());
                deliveryProduct.setSku(productRequest.getSku());
                deliveryProduct.setQuantity(orderDetails.getProducts().get(i).getQuantities());


                products.add(internalProduct);
                deliveryProducts.add(deliveryProduct);

                totalCostOfProducts += internalProduct.getQuantity() * internalProduct.getPrice();
                totalWeight += productRequest.getWeight();


            }

            System.out.println("custo total do pedido: " + totalCostOfProducts);


            BillRequest billRequest = new BillRequest();
            UUID internalOrderId = UUID.randomUUID();
            order.setId(internalOrderId);
            order.setProductList(products);
            order.setCustomer(customer);
            order.setPayment(payment);
            order.setOrderDateRequested(LocalDateTime.now());
            order.setTotalWeight(totalWeight);
            order.setTotalAmount(totalCostOfProducts);
            order.setDeliveryEstimation(LocalDateTime.now().plusDays(1));
            order.setDeliveryAddress(address);
            order.setDeliveryPrice(deliveryCost);
            order.setStatus("CREATED");


            billRequest.setCost(totalCostOfProducts + deliveryCost);
            billRequest.setDemand(order.getId());

            try {
                BillResponse postedBill = billClient.postBill(billRequest);
                payment.setBill(postedBill.getId());

            } catch (RuntimeException e) {
                System.out.println("FALHA AO CHAMAR O SERVICO DE BILLING");
            }


            DeliveryRequest deliveryRequest = new DeliveryRequest();
            deliveryRequest.setAddress(address.getPlace());
            deliveryRequest.setAddressNumber(customerRequest.getAddressNumber());
            deliveryRequest.setDeliveryPrice(deliveryCost);
            deliveryRequest.setCustomer(customer.getName());
            deliveryRequest.setProductList(deliveryProducts);
            deliveryRequest.setProductsWeight(totalWeight);
            deliveryRequest.setDemand(order.getId());

            Delivery delivery = new Delivery();

            try{
                DeliveryResponse postedDelivery = deliveryClient.postDelivery(deliveryRequest);
                delivery.setDelivery(postedDelivery.getId());
            } catch (RuntimeException e) {
                System.out.println("FALHA AO CHAMAR O SERVICO DE DELIVERY");
            }

            order.setDelivery(delivery);

            OrderStatus orderStatus = new OrderStatus();
            orderStatus.setStatus(OrderStatus.Status.CREATED);
            orderStatus.setOrderId(internalOrderId);
            orderStatus.setPaymentid(payment.getBill());
            orderStatus.setDeliveryid(delivery.getDelivery());

            orderRepository.save(order);
            return orderStatus;
        }).toList();

        OrderEvent orderEvent = new OrderEvent(orderStatusList);
        saveOrderStatus(orderStatusList);

        return orderEvent;
    }

    private void saveOrderStatus(List<OrderStatus> orderStatusList) {

        List<Order> orderList = orderStatusList.stream().map(orderStatus -> {
            Order order = new Order();
            return order;
        }).toList();

    }


    public Order obterPorCodigo(UUID id){
        return this.orderRepository.findById(id).orElseThrow(()-> new ControllerNotFoundException("pedido nao existe"));
    }

    public Page<Order> buscarTodos(Pageable pageable){
        return this.orderRepository.findAll(pageable);
    }


    public boolean paid(UUID id) {

        this.orderRepository.paid(id);
        return true;
    }

    public boolean delivered(UUID id) {

        this.orderRepository.delivered(id);
        return true;
    }

    public List<String> findAllProductsFromOrder(UUID id){
        return this.orderRepository.findAllProductNamesByPedidoId(id);
    }

    public List<String> findAllProductsQuantityFromOrder(UUID id){
        return this.orderRepository.findAllProductQuantitysByPedidoId(id);
    }
}
