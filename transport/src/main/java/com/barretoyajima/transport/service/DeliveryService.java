package com.barretoyajima.transport.service;

import com.barretoyajima.transport.controller.exception.ControllerNotFoundException;
import com.barretoyajima.transport.entity.Delivery;
import com.barretoyajima.transport.repository.DeliveryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;


    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public Delivery obterPorCodigo(UUID id){
        return this.deliveryRepository.findById(id).orElseThrow(()-> new ControllerNotFoundException("delivery nao existe"));
    }

    public Page<Delivery> buscarTodos(Pageable pageable){
        return this.deliveryRepository.findAll(pageable);
    }

    public Delivery criar(Delivery delivery){
        return this.deliveryRepository.save(delivery);
    }

    public void deletarPorId(UUID id){
        this.deliveryRepository.deleteById(id);
    }


    public boolean delivered(UUID id) {

        this.deliveryRepository.delivered(id);
        return true;
    }

    public boolean todelivery(UUID id) {

        this.deliveryRepository.todelivery(id);
        return true;
    }
}
