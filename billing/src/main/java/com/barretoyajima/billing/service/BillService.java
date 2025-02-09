package com.barretoyajima.billing.service;

import com.barretoyajima.billing.controller.exception.ControllerNotFoundException;
import com.barretoyajima.billing.dto.BillDto;
import com.barretoyajima.billing.entity.Bill;
import com.barretoyajima.billing.repository.BillRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BillService {

    private final BillRepository billRepository;

    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public Page<BillDto> findAll(Pageable pageable){
        Page<Bill> bills = billRepository.findAll(pageable);
        return bills.map(this::toDto);
    }

    public BillDto findById(UUID uuid){
        Bill bill = billRepository.findById(uuid).orElseThrow(()-> new ControllerNotFoundException("bill not found"));
        return toDto(bill);
    }

    public BillDto findByDemand(UUID id){
        Bill bill = billRepository.findByDemand(id);
        return toDto(bill);
    }

    public BillDto save(BillDto billDto){
        Bill bill = toEntity(billDto);
        bill = billRepository.save(bill);
        return toDto(bill);
    }

    public BillDto update(UUID uuid, BillDto billDto){
        try {
            Bill bill = billRepository.getReferenceById(uuid);
            bill.setDemand(billDto.demand());
            bill.setStatus(billDto.status());
            bill.setDateTime(billDto.dateTime());
            bill.setCost(billDto.cost());

            bill = billRepository.save(bill);

            return toDto(bill);
        } catch (EntityNotFoundException e){
            throw  new ControllerNotFoundException("bill not found");
        }
    }

    public void delete(UUID uuid){
        billRepository.deleteById(uuid);
    }

    public void paid(UUID id){
        this.billRepository.paid(id);
    }

    private BillDto toDto(Bill bill){
        return new BillDto(
                bill.getId(),
                bill.getDemand(),
                bill.getCost(),
                bill.getDateTime(),
                bill.getStatus()
        );
    }

    private Bill toEntity(BillDto billDto){
        return new Bill(
                billDto.id(),
                billDto.demand(),
                billDto.cost(),
                billDto.dateTime(),
                billDto.status()
        );
    }

}
