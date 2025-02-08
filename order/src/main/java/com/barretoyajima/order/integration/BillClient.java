package com.barretoyajima.order.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "bill-api")
public interface BillClient {
    @PostMapping(value = "/bills")
    BillResponse postBill(@RequestBody BillRequest billRequest);
}
