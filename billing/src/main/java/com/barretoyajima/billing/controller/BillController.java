package com.barretoyajima.billing.controller;

import com.barretoyajima.billing.dto.BillDto;
import com.barretoyajima.billing.entity.Bill;
import com.barretoyajima.billing.service.BillService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/bills")
public class BillController {

    private final BillService billService;


    public BillController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping
    public ResponseEntity<Page<BillDto>> findAll(
            @PageableDefault(size = 10, page = 0)Pageable pageable
            ){
        Page<BillDto> billDtos = billService.findAll(pageable);
        return ResponseEntity.ok(billDtos);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<BillDto> findById(@PathVariable UUID uuid){
        BillDto billDto = billService.findById(uuid);
        return ResponseEntity.ok(billDto);
    }

    @GetMapping("/demand/{id}")
    public ResponseEntity<BillDto> findByDemand(@PathVariable UUID id){
        BillDto billDto = billService.findByDemand(id);
        return ResponseEntity.ok(billDto);
    }

    @PostMapping
    public ResponseEntity<BillDto> save(@RequestBody BillDto billDto){
        BillDto savedBill = billService.save(billDto);
        return new ResponseEntity<>(savedBill, HttpStatus.CREATED);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<BillDto> update(@PathVariable UUID uuid, @RequestBody BillDto billDto){
        BillDto updatedBill = billService.update(uuid, billDto);
        return ResponseEntity.ok(updatedBill);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> delete(@PathVariable UUID uuid){
        billService.delete(uuid);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/change-status-to-paid")
    public void changeStatusToPaid(@PathVariable UUID id){
        this.billService.paid(id);
    }

}
